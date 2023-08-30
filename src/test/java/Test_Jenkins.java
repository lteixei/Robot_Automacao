

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import br.ce.wcaquino.pages.Cenarios_TelasPage;
import br.ce.wcaquino.utils.JenkinsHelper;

public class Test_Jenkins extends Cenarios_TelasPage{
  
	@Test
	public void inicializa() {
		String res="";
		try {
			res = JenkinsHelper.runJk("");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.print("resultado jk:"+res);
	}
}
