package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.DriverFactory;

public class LoginPage extends Cenarios_TelasPage {
	
	public void acessarTelaInicial(){
	    DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/33_0_09_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/33_0_07_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/33_0_06_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/33_0_05_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/31_0_27_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/30_0_34_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/28_0_27_UAT1/#/login");
	}
	
	public void setEmail(String matricula) throws InterruptedException {
	    Thread.sleep(5000);
		escrever("//label[@id='login-input1']/input[1]", matricula);
	}
	
	public void setSenha(String senha) throws InterruptedException {
	    Thread.sleep(5000);
		escrever("//input[@name='password']", senha);
	}
	
	public void entrar(){
		clicarBotao("btn-login");
	}
	
	public void logar(String email, String senha) throws InterruptedException {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
}