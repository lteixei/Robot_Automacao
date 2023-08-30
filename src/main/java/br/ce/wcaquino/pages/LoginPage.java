package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.DriverFactory;

public class LoginPage extends Cenarios_TelasPage {
	
	public void acessarTelaInicial(){
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/35_0_0_28_UAT1/");
	    DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/34_0_2_03_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/34_0_0_14_UAT1/#/login");
	    //DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/32_0_11_UAT2/#/login");
	    
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