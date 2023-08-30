package br.ce.wcaquino.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.client.JenkinsHttpConnection;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.offbytwo.jenkins.model.QueueReference;

public class JenkinsHelper {

	public static String runJk(String simcard) throws IOException, URISyntaxException {

		JenkinsHttpConnection jenkin = new JenkinsHttpClient(new URI("http://10.171.161.91:8090/"),
				"API","11daa0121f45f82d3c5806c5effc54403f");
		List<NameValuePair> parametros = new ArrayList<NameValuePair>();
		parametros.add(new BasicNameValuePair("AMBIENTE","UAT1"));
		parametros.add(new BasicNameValuePair("MSISDN",""));
		parametros.add(new BasicNameValuePair("DDD","15"));
		parametros.add(new BasicNameValuePair("DOCUMENTO",""));
		parametros.add(new BasicNameValuePair("CHIP",""));
		parametros.add(new BasicNameValuePair("CONTRACT_TYPE","GSM"));
		parametros.add(new BasicNameValuePair("CLIENT_TYPE","PF"));
		HttpResponse resp = jenkin.post_form_with_result("/job/Obter_massa/buildWithParameters",
				parametros, false);
		String retorno = resp.toString();
		return(retorno);
	}
	
	public static Map<String,String> getParametros(){
		Map<String,String> parametros = new HashMap<String, String>();
        parametros.put("AMBIENTE","UAT1");
		parametros.put("MSISDN","");
		parametros.put("DDD","15");
		parametros.put("DOCUMENTO","");
		parametros.put("CHIP","");
		parametros.put("CONTRACT_TYPE","GSM");
		parametros.put("CLIENT_TYPE","PF");
		return parametros;
	}
	
	
	
	private String JENKIN_URL = "http://10.171.161.91:8090/";
	private String JENKIN_USER= "API";
	private String JENKIN_TOKEN= "11daa0121f45f82d3c5806c5effc54403f";

	private JenkinsServer jenkins;
	private JenkinsHttpClient jenkinsHttpClient;

	public JenkinsServer getJenkins() {
        return jenkins;
    }

    public JenkinsHttpClient getJenkinsHttpClient() {
        return jenkinsHttpClient;
    }
	
	public void init(){
		try{
			jenkins = new JenkinsServer(new URI(JENKIN_URL), JENKIN_USER, JENKIN_TOKEN);
			jenkinsHttpClient = new JenkinsHttpClient(new URI(JENKIN_URL), JENKIN_USER, JENKIN_TOKEN);

		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public JobWithDetails getJobByJobName(String jobName){
		try{
			return jenkins.getJob(jobName);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String build(String jobName){

		try {
			Job job = jenkins.getJob(jobName);

			int lastBuildNumber = job.details().getLastBuild().getNumber();
			int nextBuildNumber = job.details().getNextBuildNumber();

			QueueReference queueReference = job.build(true);

			int waitFor = 0;
			while(job.details().isInQueue()){
				waitFor++;

				Thread.sleep(5000);
				if(waitFor>4) return "Job is built successfully, but is in Queue";

			}
			JobWithDetails jobWithDetails =job.details();
			if(job.details().getBuildByNumber(nextBuildNumber).details().isBuilding()) {

				return "Jenkins job "+ jobName +" is building with Build Number: " + nextBuildNumber;
			}
			else {

				return "Jenkins job is stuck for :" + jobName;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String build(String jobName, Map<String,String> parameters){

		try {
			Job job = jenkins.getJob(jobName);

			int lastBuildNumber = job.details().getLastBuild().getNumber();
			int nextBuildNumber = job.details().getNextBuildNumber();

			QueueReference queueReference = job.build(parameters,true);

			int waitFor = 0;
			while(job.details().isInQueue()){
				waitFor++;

				Thread.sleep(5000);
				if(waitFor>4) return "Job is built successfully, but is in Queue";

			}
			JobWithDetails jobWithDetails =job.details();
			if(job.details().getBuildByNumber(nextBuildNumber).details().isBuilding()) {

				return "Jenkins job "+ jobName +" is building with Build Number: " + nextBuildNumber;
			}
			else {

				return "Jenkins job is stuck for :" + jobName;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean getStatusFinishedJobWithBuildNumber(String jobName, int buildNumber){
		try {
			int last = jenkins.getJob(jobName).getLastBuild().getNumber();
			return (buildNumber == last);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String showConsoleLogForJobWithBuildNumber(String jobName, int buildNumber){

		try {
			String fullLog = jenkins.getJob(jobName).getBuildByNumber(buildNumber).details().getConsoleOutputText();
			return fullLog.substring(fullLog.length()-1000, fullLog.length()-1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getLatestBuildNumber(String jobName){
		try{
			return jenkins.getJob(jobName).getLastBuild().getNumber();
		}catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	public boolean waitFinish(String jobName, int buildNumber){
		boolean p = getStatusFinishedJobWithBuildNumber(jobName,buildNumber);
		while (!p){
			try {
				Thread.sleep(1000);
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			p = getStatusFinishedJobWithBuildNumber(jobName,buildNumber);
		}
		return p;

	}
}
