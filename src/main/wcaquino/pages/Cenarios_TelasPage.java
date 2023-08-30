package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.steadystate.css.parser.Locatable;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.utils.DataBaseUtils;

public class Cenarios_TelasPage extends BasePage {
		
	
	// ######## INICIALIZAÇÃO - ENDEREÇO E LOGIN ########

	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://apptimvendasdev.internal.timbrasil.com.br/30_0_31_UAT1/#/login");
	}

	public void setEmail(String matricula) throws InterruptedException {
		escrever("//label[@id='login-input1']/input[1]", matricula);
	}

	public void setSenha(String senha) throws InterruptedException {
		escrever("//input[@name='password']", senha);
	}

	public void entrar() {
		clicarBotao("btn-login");
	}

	public void logar(String email, String senha) throws InterruptedException {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	// ########################################################
    

    // ######## ASSERT - VALIDAR NOME ########
	
	
	//public void validaNome(String string) throws InterruptedException {
	//    validaTexto("//input[@name='password']", string);
    //}
	

	// ########################################################
	

	// ######## IDENTIFICAÇÃO DE PDV ########
	

	public void sendPDV(String pdv) throws InterruptedException {
		Thread.sleep(15000);
		escreverSemTroca("//ion-searchbar[@id='searchbar-pdv']/div/input", pdv);
		Thread.sleep(2000);
	}

	public void EscolhaPDVDutra() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//ion-label[contains(.,'E A DUTRA')]");
	}

	public void EscolhaPDVVarejo() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//ion-label[contains(.,'VAREJO_LASA_L229')]");
	}

	public void EscolhaPDVMagazineluiza() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//ion-label[contains(.,'MAGAZINELUIZA_SP_GUA')]");
	}

	public void EscolhaPDVMorumbi() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//ion-label[contains(.,'LP LOJA MORUMBI SHOP')]");
	}

	public void EscolhaPDVTIM_REVENDAS() throws InterruptedException {
		clicarXpath("//ion-label[contains(.,'TIM REVENDAS')]");
	}

	public void confirmaPDV() throws InterruptedException {
		clicarXpath("//button[@id='button-back']/span");
	}

	public void fechapopupPDV() throws InterruptedException {
		Thread.sleep(3000);
		clicarXpath("//*[contains(@class,'alert-button-group')]");
	}

	// ########################################################
	

	// ######## AMBIENTE DE ATENDIMENTO ########
	

	public void clickAntesAtendimento() throws InterruptedException {
	    Thread.sleep(1000);
		clicarXpath("//ion-select/button/span");
	}

	public void clickAtendimento() throws InterruptedException {
		clicarXpath("//span[contains(.,'MESA 03')]");
	}

	public void proximoAmbienteAtend() throws InterruptedException {
		clicarXpath("//div[2]/button/span");
		Thread.sleep(30000);
	}
	
	// ########################################################
	

	// ######## ATENDIMENTO ########
	

	public void gerarNovoProtocolo() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-attendance/ion-content/div[2]/ion-card[4]/ion-card-content/ion-list/ion-item[1]/div[1]/div");
    }
	
	public void insertNovoTel(String newtel) throws InterruptedException {
		Thread.sleep(10000);
		escreverSemTroca("//input[@type='tel']", newtel);
	}
	
	public void clickTimPre() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'TIM PRÉ')]");
    }

	public void clickTimPreTop() throws InterruptedException {
		Thread.sleep(15000);
		//clicarXpath("//*[@id=\"msisdn-11983090021\"]/div[1]/div[1]");
		clicarXpath("//p[contains(.,'TIM PRÉ TOP')]");
	}
	
	public void clickTimControleSmartFlex() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'TIM Controle Smart Flex')]");
    }
	
	
	public void clickTimControle_Giga_A_Promo_Express31() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"msisdn-24981240945\"]/div[1]/div[1]");
    }
	

	public void clickTimControle_A_Plus() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//p[contains(.,'TIM Controle A Plus 4 0')]");
	}
	
	public void clickPosTim() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//p[contains(.,'PÓS DA TIM')]");
	}
	
	public void clickBasicoPosPagoMovel() throws InterruptedException {
		Thread.sleep(12000);
		clicarXpath("//p[contains(.,'Básico Pós-Pago Móvel')]");
	}
	
	public void clickTimBlack_A_3() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//p[contains(.,'TIM Black A 3 0')]");
	}
	
	public void clickTimBlack_C_Ultra() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//p[contains(.,'TIM Black C Ultra')]");
	}

	public void clickTimControle_RedesSociais_4() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//p[contains(.,'TIM Controle Redes Sociais 4 0')]");
	}
	
	public void clickBlackMulti_A_Hero_3_0() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//p[contains(.,'TIM Black Multi A Hero 3 0')]");
    }

	public void clickOpcaoDemorada() throws InterruptedException {
		Thread.sleep(15000);
		clicarXpath("//ion-radio/button/span");
	}
	
	public void clickOpcao() throws InterruptedException {
		Thread.sleep(15000);
		clicarXpath("//ion-radio/button/span");
	}

	public void clickCampoDDD() throws InterruptedException {
	    Thread.sleep(1000);
	    clicarXpath("//ion-select/button/span");
	}

	public void clickDDD() throws InterruptedException {
	    Thread.sleep(1000);
		clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
	}
	        
	public void clickDDD21() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
    } 
            
            
    public void clickDDD11() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
    }       
            
    public void clickTim_Black_A_50() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"msisdn-12981461517\"]/div[1]/div[1]");
    }         
	
	public void clickTim_Black_A_30() throws InterruptedException {
	    Thread.sleep(10000);
	    clicarXpath("//p[contains(.,'TIM Black A 3 0')]");
    } 

	public void proximoAtendimento() throws InterruptedException {
		clicarXpath("//button[@id='button-next']/span");
		Thread.sleep(8000);
	}

	// ########################################################
	
	// ######## NOVO PRTOCOLO ########
	
	public void inserirTelefone(String insertnewtel) throws InterruptedException {
        Thread.sleep(10000);
        escreverSemTroca("/html/body/ion-app/ng-component/ion-nav/page-consult-client/ion-content/div[2]/ion-card/ion-card-content/ion-row/ion-col[1]/ion-input", insertnewtel);
    } 

    public void btnPesquisar() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-consult-client/ion-content/div[2]/ion-card/ion-card-content/ion-row/ion-col[2]/button/span");
    } 

    public void cadastrarNovoCiente() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-consult-client/ion-content/div[2]/ion-card[2]/ion-card-content/ion-row[2]/ion-col/button");
    } 

    public void inserirNome(String insertnewname) throws InterruptedException {
        Thread.sleep(10000);
        escreverSemTroca("/html/body/ion-app/ng-component/ion-nav/page-potential-client-pf/ion-content/div[2]/ion-card/ion-card-content/ion-list/ion-item[1]/div[1]/div/ion-input", insertnewname);
    } 

    public void clicarOperadora() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("//*[@id=\"select-164-0\"]/span");
    } 

    public void escolherOperadora() throws InterruptedException {
        Thread.sleep(15000);
        clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[1]");
    } 

	
	
	// ########################################################

	// ######## NO PÓS VENDA ########
	

	public void clickMigracao() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//span[contains(.,'Migração')]");
		Thread.sleep(2000);
	}

	public void clickMigracaoTT() throws InterruptedException {
		clicarXpath("//span[contains(.,'Migração com TT')]");
		Thread.sleep(10000);
	}

	public void clickTrocaChip() throws InterruptedException {
		Thread.sleep(6000);
		clicarXpath("//span[contains(.,'Troca de Chip')]");
	}

	public void clickTrocaPlano() throws InterruptedException {
		clicarXpath("//span[contains(.,'Troca de Plano')]");
		Thread.sleep(10000);
	}

	public void clickFinalizar() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//span[contains(.,'Finalizar Atendimento')]");
	}

	public void clickNovoProtocolo() throws InterruptedException {
		clicarXpath("//span[contains(.,'Novo Protocolo')]");
		Thread.sleep(10000);
	}

	public void clickConsultarProtocolos() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//ion-label[contains(.,'Consultar Protocolos')]");
	}

	// ########################################################
	
	

	// ######## MIGRAÇÃO ########
	

	public void clickPre_ControleFatura() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//span[contains(.,'Pré para Controle Fatura')]");
		Thread.sleep(5000);
	}

	public void clickPre_ControleExpress() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//span[contains(.,'Pré para Express')]");
		Thread.sleep(5000);
	}

	public void clickPre_ControleFlex() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("/span[contains(.,'Pré para Controle Flex')]");
		Thread.sleep(5000);
	}

	public void clickPre_PosPago_Fatura() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//span[contains(.,'Pré para Pós-Pago Fatura')]");
		Thread.sleep(5000);
	}

	public void clickPre_PosPago_Express() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//span[contains(.,'Pré para Pós-Pago Express')]");
		Thread.sleep(5000);
	}

	public void clickPre_TimBlackMultiExpress() throws InterruptedException {
	    Thread.sleep(10000);
	    clicarXpath("//span[contains(.,'Pré para TIM Black Multi Express')]");
		Thread.sleep(5000);
	}

	public void clickPre_TimBlackMultiFatura() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//span[contains(.,'Pré para TIM Black Multi Fatura')]");
		Thread.sleep(5000);
	}

	// ########################################################
	
	

	// ######## DADOS COMPLEMENTAARES ########
	

	public void clickSexoFeminino() throws InterruptedException { 
	    Thread.sleep(5000);
	    clicarXpath("//ion-col[2]/ion-item/div/ion-radio/button/span");
	}

	public void clickSexoMasculino() throws InterruptedException { 
	    Thread.sleep(5000);
	    clicarXpath("//ion-col[1]/ion-item/div/ion-radio/button/span");
	}

	public void ckickAntesEscolherDoc() throws InterruptedException {
		clicarXpath("//ion-select/button/span");
	}

	public void ckicEscolherDocID() throws InterruptedException {
		clicarXpath("//div/div/button[2]/span");
	}

	public void setNumeroIdentidade(String numId) throws InterruptedException {
	    escreverSemTroca("//input[@type='tel']", numId);
	}
	
	
	public void setNumeroDocumento(String numId) throws InterruptedException {
        Thread.sleep(1000);
        escreverSemTroca("//ion-input[@id='doc-number']/input", numId);
    }

	public void setDataEmissão(String dtemissao) throws InterruptedException {
	    Thread.sleep(1000);
		escreverSemTroca("//ion-input[@id='date']/input", dtemissao);
	}

	public void setOrgaoEmissor(String orgemissor) throws InterruptedException {
	    Thread.sleep(1000);
	    escreverSemTroca("(//input[@type='text'])[2]", orgemissor);
	}
	
	public void setOrgaoEmissorSSP(String orgemissor) throws InterruptedException {
        Thread.sleep(1000);
        escreverSemTroca("//*[@id=\"issuing-organ\"]/input", orgemissor);
    }

	public void clickAntesUF() throws InterruptedException {
	    Thread.sleep(1000);
		clicarXpath("//ion-item[5]/div/div/ion-select/button/span");
	}

	public void clickUF() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("/html/body/ion-app/ion-action-sheet/div/div/div[1]/button[26]/span");
	}
	
	public void clickUF_RJ() throws InterruptedException {
        Thread.sleep(2000);
        clicarXpath("//button[19]/span");
    }

	public void setTelContato(String telcont) throws InterruptedException {
		Thread.sleep(2000);
		escreverSemTroca("(//input[@type='tel'])[3]", telcont);
	}
	
	public void setTelContato2(String telcont) throws InterruptedException {
        Thread.sleep(2000);
        escreverSemTroca("//ion-input[@id='tel-contact']/input", telcont);

	}   
	public void proximoDadosComplementares() throws InterruptedException {
		clicarXpath("//div[2]/button[2]");
		Thread.sleep(10000);
	}
	
	public void proximoDadosCompDemorado() throws InterruptedException {
	    Thread.sleep(5000);
        clicarXpath("//div[2]/button[2]");
    }

	// ########################################################
	
	

	// ######## DADOS DO CLIENTE ########
	

	public void setNome(String nome) throws InterruptedException {
		escreverSemTroca("//input[@type='text']", nome);
	}

	public void setEmailCliente(String email) throws InterruptedException {
		Thread.sleep(1000);
		escreverSemTroca("//input[@type='email']", email);
	}

	public void confirmaEmail(String confemail) throws InterruptedException {
		escreverSemTroca("(//input[@type='email'])[2]", confemail);
	}

	public void validaEmail() throws InterruptedException {
		clicarXpath("//span[contains(.,'Validar')]");
	}

	public void checkNotEmail() throws InterruptedException {
		clicarXpath("//ion-checkbox/button/span");
	}

	public void setDataNasc(String dtnascimento) throws InterruptedException {
		escreverSemTroca("//ion-input[@id='client-birthdate']/input", dtnascimento);
	}

	public void setNomeMae(String nomemae) throws InterruptedException {
		Thread.sleep(1000);
		escreverSemTroca("(//input[@type='text'])[2]", nomemae);
	}

	public void apagaCEP() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("(//ion-item[5]/div/div/ion-input/input");
	}
	
	public void setCEP(String cep) throws InterruptedException {
		escreverSemTroca("(//input[@type='tel'])[2]", cep);
	}
	
	//##### APAGA O CONTEÚDO - LIMPA A CÉLULA
	public void setCEPTroca(String cep) throws InterruptedException {
	    Thread.sleep(5000);
	    //##### INDICA O CAMPO ONDE SERÁ APAGADO A INFORMAÇÃO
		WebElement elemento = getDriver().findElement(By.xpath("(//input[@type='tel'])[2]"));
		
		// Seleciona texto do começo do campo até o fim, segurando SHIFT e depois, aplica o Backspace
		elemento.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);
		
		// Seleciona todo o texto dando o comando "CONTROL + A" e depois, aplica o Backspace          
		elemento.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

		// Apaga qualquer texto no componente           
		elemento.clear();
		
		escreverSemTroca("(//input[@type='tel'])[2]", cep);
	}

	public void buscarCEP() throws InterruptedException {
		clicarXpath("//button[@id='postcode-search']/span");
		Thread.sleep(2000);
	}

	public void proximoDadosClientes() throws InterruptedException {
		clicarXpath("//div[2]/button[2]");
		Thread.sleep(2000);
	}

	public void poupupClientes() throws InterruptedException {
		clicarXpath("//span[contains(.,'Estou Ciente')]");
	}

	// ########################################################
	
	

	// ######## ESCOLHA OFERTA ########
	

	public void clickOferta1() throws InterruptedException {
	    Thread.sleep(5000);
		clicarXpath("//*[@id=\"offer-PR00460\"]/div[1]/div");
	}

	public void clickOferta2() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("//p[contains(.,'TIM PRÉ TOP MAIS 3.0 (WhatsApp + Deezer Go + Prime Video + Voz ilimitada + internet p/ usar como quiser)')]");
	}

	public void fechaPopup() throws InterruptedException {
	    Thread.sleep(1000);
		clicarXpath("//div[3]/button/span");
	}

	public void proximoOferta() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]");
	}

	// ########################################################
	

	// ######## ENDEREÇO DO CLIENTE ########
	

	public void clickAntesLogradouro() throws InterruptedException {
		Thread.sleep(15000);
		clicarXpath("//ion-item[5]/div/div/ion-select/button/span");
	}

	public void clickTipoLogradouro() throws InterruptedException {
		clicarXpath("//span[contains(.,'RUA')]");
	}

	public void setNomeDaRua(String rua) throws InterruptedException {
		escreverSemTroca("(//input[@type='text'])[3]", rua);
	}

	public void setNumero(String numero) throws InterruptedException {
	    Thread.sleep(10000);
		escreverSemTroca("(//input[@type='tel'])[2]", numero);
	}

	public void proximoEnderecoClientes() throws InterruptedException {
		clicarXpath("//div[2]/button[2]/span");
		Thread.sleep(8000);
	}
	
	public void proximoEnderecoClientes2() throws InterruptedException {
	    Thread.sleep(2000);
        clicarXpath("//div[2]/button[2]/span");
        Thread.sleep(10000);
    }
	
	//#############//#############//#############//#############//
	
	//######### NOVA ATUALIZAÇÃO - OPÇÃO NOVA
	
	public void clickVerificarTIMLIVE() throws InterruptedException {
	    Thread.sleep(3000);
	    clicarCSS(".button-clear > .button-inner");
	    Thread.sleep(2000);
    }

    public void clickTipoDeComplemento() throws InterruptedException {
        Thread.sleep(1000);
        clicarXpath("//ion-card-content/ion-item/div/div/ion-select/button/span");
    }
	
    public void escolhaTipoDeComplemento() throws InterruptedException {
        clicarXpath("//span[contains(.,'Apartamento')]");
    }
    
    public void clickComplemento() throws InterruptedException {
        clicarXpath("//ion-item[2]/div/div/ion-input/input");
    }
    
    public void setComplemento(String complemento) throws InterruptedException {
        escreverSemTroca("//ion-item[2]/div/div/ion-input/input", complemento);
    }
	

	// ########################################################
	

	// ######## ESCOLHA NUMERO ########
	

	public void clickNumero() throws InterruptedException {
	    Thread.sleep(5000);
		clicarXpath("//ion-list/ion-item/div/ion-radio/button/span");
	}

	public void proximoEscolhaNum() throws InterruptedException {
		clicarXpath("//div[2]/button[2]/span");
	}

	// ########################################################
	

	// ######## ESCOLHA PRODUTO ########
	

	public void escolherProduto() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("(//button[@id='button-back']/span)[2]");
	}

	// ########################################################
	

	// ######## ESCOLHA SEGMENTO ########
	

	public void clickPrepago() throws InterruptedException {
		clicarXpath("//span[contains(.,'Pré-Pago')]");
		Thread.sleep(10000);
	}
	
	
	public void clickPospago() throws InterruptedException {
        clicarXpath("//span[contains(.,'Pós-Pago')]");
        Thread.sleep(10000);
    }
	

	public void clickControleExpress() throws InterruptedException {
		clicarXpath("//span[contains(.,'Controle Express')]");
		Thread.sleep(10000);
	}

	public void clickControleFatura() throws InterruptedException {
		clicarXpath("//span[contains(.,'Controle Fatura')]");
		Thread.sleep(10000);
	}

	public void clickControleFlex() throws InterruptedException {
		clicarXpath("//span[contains(.,'Controle Flex')]");
		Thread.sleep(10000);
	}	

	public void clickPosPagoFatura() throws InterruptedException {
		clicarXpath("//span[contains(.,'Pós-Pago Fatura')]");
		Thread.sleep(10000);
	}

	public void clickPosPagoExpress() throws InterruptedException {
		clicarXpath("//span[contains(.,'Pós-Pago Express')]");
		Thread.sleep(10000);
	}

	public void clickTimBlackMultiFatura() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//span[contains(.,'TIM Black Multi Fatura')]");
	}

	public void clickTimBlackMultiExpress() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//span[contains(.,'TIM Black Multi Express')]");
	}
	
	public void clickTimBlackMultiB3() throws InterruptedException {
	    Thread.sleep(10000);
		clicarXpath("//p[contains(.,'60GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais')];");
	}

	// ########################################################
	
	

	// ######## FIDELIZAÇÃO DE APARELHO ########
	

	public void setIMEI(String imei) throws InterruptedException {
		Thread.sleep(5000);
		escreverSemTroca("//input[@type='text']", imei);
	}

	public void clickPopupIMEI() throws InterruptedException {
		clicarXpath("//span[contains(.,'OK')]");
	}

	public void validarIMEI() throws InterruptedException {
		clicarXpath("//span[contains(.,'Validar')]");
		Thread.sleep(5000);
	}

	public void clickBotaoFidelAparelho() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("//span[contains(.,'Próximo')]");
	}

	// ########################################################
	

	// ######## INFORMAÇÃO DA FATURA ########
	
	public void clickDataVencimento_P() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("(//button[@id='undefined']/span)");
	}

	public void clickDataVencimento() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//*[@id=\"dueDate-20\"]/ion-col[1]");
	}
	
	public void clickDebitoAtutomatico() throws InterruptedException {
		clicarXpath("//ion-card[4]/ion-row/ion-col[2]");
	}
	
	public void clickBanco() throws InterruptedException {
		clicarXpath("//ion-select/button/span");
	}
	
	public void escolhaBanco() throws InterruptedException {
		clicarXpath("//span[contains(.,'BANCO DO BRASIL S.A.')]");
	}
	
	public void setAgencia(String agencia) throws InterruptedException {
		escreverSemTroca("//ion-list/ion-item[2]/div/div/ion-input/input", agencia);
	}
	
	public void setConta(String conta) throws InterruptedException {
		escreverSemTroca("//ion-item[3]/div/div/ion-input/input", conta);
	}

	public void clickBotaoInfFatura() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]");
		Thread.sleep(5000);
	}

	// ########################################################
	
	

	// ######## INSERIR E TROCA DE CHIP ########
	

	public void setCHIP(String chip) throws InterruptedException {
		Thread.sleep(5000);
		escreverSemTroca("//ion-input[@id='chip-barcode']/input", chip);
	}

	public void setTrocaCHIP(String chip) throws InterruptedException {
		Thread.sleep(15000);
		escreverSemTroca("//ion-input[@id='chip-barcode']/input", chip);
	}
	
	public void clickMotivoTrocaChip() throws InterruptedException {
		clicarXpath("//ion-select/button/span"); 
	}

	public void clickMotivoComGarantia_TrocaChip() throws InterruptedException {
		clicarXpath("//div/div/button[2]/span"); //COM GARANTIA
	}

	public void clickMotivoSemGarantia_TrocaChip() throws InterruptedException {
		clicarXpath("//div/div/button[3]/span"); //SEM GARANTIA
	}
	
	public void clickMotivoPerda_TrocaChip() throws InterruptedException {
        clicarXpath("//div/div/button[5]/span"); //PERDA
    }

	public void proximoInserirCHIP() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]");
		Thread.sleep(5000);
	}
	
// ########################################################
 

	// ######## NOVO ATENDIMENTO ########
	

	public void setCPF(String cpf) throws InterruptedException {
		escreverSemTroca("//input[@type='tel']", cpf);
	}

	public void setTelefone(String telefone) throws InterruptedException {
		Thread.sleep(2000);
		escreverSemTroca("//ion-input[@id='input-tel-protocol']/input", telefone);
	}

	public void proximoNovoAtendimento() throws InterruptedException {
		clicarXpath("//div[2]/button/span");
		Thread.sleep(8000);
	}

	// ########################################################
	
	
	// ######## PLANOS ########	

	// ######## PLANO TIM CONTROLE GIGA ########

	// PLANO TIM CONTROLE GIGA A PROMO EXPRESS 3 1
	public void clickPlano1() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//*[@id=\"plan-1-1DT4BJP\"]/div[2]/div");
		//clicarXpath("//p[contains(.,'6GB + Ligações Ilimitadas, Roaming Nacional, Whatsapp, Messenger e Telegram, Bancah Light,  Aya Books Light, TIM Segurança Digital e Babbel')]");
	}

	// PLANO TIM CONTROLE GIGA B PROMO EXPRESS 3 1
	public void clickPlano2() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//*[@id=\"plan-1-1DT4BJP\"]/div[2]/div/ion-label/p");
	}

	// PLANO TIM CONTROLE SMART 4 0
	public void clickPlanoTimControleSmart_4() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//ion-item[@id='plan-1-11L5P25']/div[2]/div/ion-label/ion-row/ion-col/h1");
	}

			// SEM FIDELIZAÇÃO
			public void clickSemFidelizacao() throws InterruptedException {
				clicarXpath("//ion-radio/button/span");
			}

	// PLANO TIM CONTROLE SMART 4 0
	public void clickPlano3() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//*[@id=\"plan-1-11L5P25\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
	}

	// PLANO TIM CONTROLE GIGA C EXPRESS 3 1
	public void clickPlano4() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//ion-card[4]/ion-card-header");
	}
			
			// PLANO TIM CONTROLE GIGA C EXPRESS 3 1
			public void clickPlano4_A() throws InterruptedException {
				clicarXpath("//p[contains(.,'6,6GB + Ligações Ilimitadas, Roaming Nacional, Facebook, Instagram, Twitter, Whatsapp, Messenger e Telegram,  Bancah Premium + Jornais e Aya Books')]");
			}

	// ############################################################
	

	// ######## PLANO TIM BLACK DEPENDENTE ########

	// ########PLANO DEPENDENTE ########
	public void clickPlanoDependente() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("//ion-row[2]/ion-col");
	}

	// ######## PLANO SEM FIDELIZACAO ########
	public void clickPlanoSemFidel() throws InterruptedException {
		clicarXpath("//ion-radio/button/span");
	}

	public void clickBotaoBlackDep() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]");
	}

	// ############################################################
	
	
	// ######## PLANO POS PAGO FATURA #######
		
	public void clickPlanoPosPagoFatura() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//ion-card[5]/ion-card-header");
	}
	
	// ############################################################
	

	// ######## PLANO TIM BLACK A 3 ########
	
	
	public void clickPlanoTimBlack_A3() throws InterruptedException {
		clicarXpath("//p[contains(.,'15GB, Ligações e SMS ilimitados, Audiobook By Ubook Premium, Bancah Premium + Jornais, TIM Segurança Digital Premium, TIM Music by Deezer, Reforça e Apps de Redes Sociais.')]");
	}
		
			// ######## PLANO SEM FIDELIZAÇÃO ########
			public void clickPlanoSemFidelizacao() throws InterruptedException {
				clicarXpath("//span[contains(.,'Sem Fidelização')]");
			}
				
	// ######## PLANO TIM BLACK C HERO 3 ########
	public void clickPlanoTimBlack_HERO_C3() throws InterruptedException {
		clicarXpath("//");
	}

	// ######## PLANO TIM BLACK B 3 ########
	public void clickPlanoTimBlack_B3() throws InterruptedException {
		clicarXpath("//");
	}
		
	// ######## POP UP ########
	public void clickPlanoPosPop_Up() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("//span[contains(.,'Sim')]");
		Thread.sleep(5000);
	}
				
	public void clickBotaoProximoPos() throws InterruptedException {
		clicarXpath("//button[contains(.,'Próximo')]");
		Thread.sleep(5000);
	}
	
	public void clickPlanoBlackMult_Fatura() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//ion-card[8]/ion-card-header");
    }
	
	public void clickPlanoTimBlackMult_titular() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//ion-col/ion-item/div/div/ion-label/ion-row/ion-col");
    }
	
	public void clickPlanoTimBlackMult_D30() throws InterruptedException {
        Thread.sleep(5000);
        clicarXpath("//p[contains(.,'180GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais.')]");
    }

		
	// ############################################################
		
			// ######## PLANO TIM BLACK EXPRESS 2.0 ########
	
	// ########PLANO DEPENDENTE ########
	
	public void clickPlanoBlack_A_Express_2() throws InterruptedException {
	    Thread.sleep(5000);
		clicarXpath("//*[@id=\"plan-1-2ETPAAX\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
				//"//p[contains(.,'17GB, Ligações e SMS ilimitados, Aya Books, Bancah Premium Jornais, TIM Segurança Digital Light, TIM Music by Deezer e Apps de Redes Sociais.')]");
	}

	public void clickPlanoBlack_B_Express_2() throws InterruptedException {
	    Thread.sleep(10000);
	    clicarXpath("//*[@id=\"msisdn-12981118605\"]/div[1]/div[1]");
				//p[contains(.,'22GB, Ligações e SMS ilimitados, Aya Books, Bancah Premium Jornais, TIM Segurança Digital, TIM Music by Deezer e Apps de Redes Sociais.')]");
	}

	public void clickPlanoBlack_C_Express_2() throws InterruptedException {
		clicarXpath(
				"//p[contains(.,'27GB, Ligações e SMS ilimitados, Aya Books Premium, Bancah Premium Jornais, TIM Segurança Digital, TIM Music by Deezer e Apps de Redes Sociais.')]");
	}

	public void clickBotaoBlackExpress() throws InterruptedException {
		clicarXpath("//button[contains(.,'Próximo')]");
	}

	// ############################################################
	

	// ######## PLANO TIM BLACK A 3 ########	
	
	public void clickPlanoTimBlackA3() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath(
				"//p[contains(.,'15GB, Ligações e SMS ilimitados, Audiobook By Ubook Premium, Bancah Premium + Jornais, TIM Segurança Digital Premium, TIM Music by Deezer, Reforça e Apps de Redes Sociais.')]");
		Thread.sleep(5000);
	}
	
	public void clickPlanoTimBlackB3() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath(
                "//*[@id=\"plan-1-15YAXJW\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
        Thread.sleep(5000);
    }

			// ######## SEM FIDELIZAÇÃO ########
	
			public void clickSemFidel() throws InterruptedException {
					clicarXpath("//ion-radio/button/span");
					Thread.sleep(5000);
			}

			// ######## FIDELIZAÇÃO DO APARELHO ########
			
			public void clickFidelApar2() throws InterruptedException {
                clicarXpath("//*[@id=\"rb-104-0\"]/span");
                Thread.sleep(5000);
            }
			
			public void clickFidelApar() throws InterruptedException {
				clicarXpath("//ion-item[3]/ion-radio/button/span");
				Thread.sleep(5000);
			}

			// ######## FIDELIZAÇÃO DO PLANO + APARELHO ########
			
			public void clickFidelPlano_Apar() throws InterruptedException {
				clicarXpath("//ion-item[5]/ion-radio/button/span");
				Thread.sleep(5000);
			}

	public void clickBotaoBlack() throws InterruptedException {
		clicarXpath("//button[contains(.,'Próximo')]");
	}

	// ############################################################
	
	
// ######## PLANO TIM BLACK A 3 ########   
    
    public void clickPlanoTimBlackA_5_0() throws InterruptedException {
        Thread.sleep(10000);
        clicarXpath("//*[@id=\"plan-1-15YAXIP\"]/div[2]/div");
        Thread.sleep(15000);
    }
    
               // ######## SEM FIDELIZAÇÃO ########
    
            public void clickSemFidelizacao5_0() throws InterruptedException {
                    clicarXpath("//ion-radio/button/span");
                    Thread.sleep(5000);
            }
		
         // ############################################################
            
            
	// ######## PLANO TIM CONTROLE REDES SOCIAIS 4 0 ########
	

	public void clickPlano() throws InterruptedException {
		Thread.sleep(20000);
		clicarXpath("//div[2]/ion-item/div[2]/div/ion-label/ion-row[2]/ion-col/p");
	}//TIM CONTROLE SMART 40 - XPATH //*[@id="plan-1-11L5P25"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p

				// PLANO SEM FIDELIZAÇÃO
				public void clickOpacao1() throws InterruptedException {
					clicarXpath("//ion-radio/button/span");
				}

				// PLANO FIDELIZAÇÃO DO PLANO
				public void clickOpacao2() throws InterruptedException {
					clicarXpath("//ion-item[2]/ion-radio/button/span");
				}

				// PLANO FIDELIZAÇÃO DO APARELHO
				public void clickOpacao3() throws InterruptedException {
					clicarXpath("//ion-item[3]/ion-radio/button/span");
				}
				
				// PLANO FIDELIZAÇÃO PLANO + APARELHO NÃO FIDELIZADO
				public void clickOpacao4() throws InterruptedException {
					clicarXpath("//ion-item[4]/ion-radio/button/span");
				}

				// PLANO FIDELIZAÇÃO PLANO + APARELHO
				public void clickOpacao5() throws InterruptedException {
				    Thread.sleep(10000);
				    clicarXpath("//ion-item[5]/ion-radio/button/span");
				}

					// PLANO APARELHOS NÃO FIDELIZADOS
				public void clickOpacao6() throws InterruptedException {
					clicarXpath("//ion-item[6]/ion-radio/button/span");
				}

	// ############################################################
				
				
	// ######## PLANO TIM BLACK MULTI FATURA ########

	public void escolhaTimBMF() throws InterruptedException {
		clicarXpath("//ion-card[8]/ion-card-header");
	}
	
	// ######## TITULAR ########
	public void escolhaTitularBMF() throws InterruptedException {
		clicarXpath("//ion-col[contains(.,'Titular')]");
	}
	
	// ######## PLANO TIM BLACK MULTI A HERO 3 0 ########
	public void clickBlackMulti_A_Hero3_0() throws InterruptedException {
	    Thread.sleep(10000);
	    clicarXpath("//*[@id=\"plan-1-11VJ069\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
	}
				// ######## SEM FIDELIZAÇÃO ########
				public void clickMulti_A_Hero3_0_SemFid() throws InterruptedException {
					clicarXpath("//span[contains(.,'Sem Fidelização')]");
				}
	
	// ############################################################
	
	
	// ######## PLANO TIM BLACK MULTI 3 0 ########
	
	public void clickMultiAHERO3_0() throws InterruptedException {
		clicarXpath("//*[@id=\"plan-1-11VJ069\"]/div[2]/div/ion-label/ion-row[2]/ion-col[1]/p");
	}
				
	public void clickMultiA3_0() throws InterruptedException {
		clicarXpath("//p[contains(.,'30GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 500GB, TIM Segurança Digital, Reforça, Band News, Band Sports e Apps de Redes Sociais.')]");
	}
	
	// ######## PLANO B 3 0 ########
	public void clickMultiB3_0() throws InterruptedException {
		clicarXpath("//p[contains(.,'60GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais')]");
	}

	// ######## PLANO C 3 0 ########
	public void clickMultiC3_0() throws InterruptedException {
		clicarXpath("//p[contains(.,'100GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais.')]");
	}

	// ######## PLANO D 3 0 ########
	public void clickMultiD3_0() throws InterruptedException {
		clicarXpath("//p[contains(.,'180GB, Ligações e SMS ilimitados, Audiobooks by Ubook Platinum, Babbel 3, Chefsclub, Loja Gameloft, Bancah Premium + Jornais, TIM Gestão Digital, Deezer, TIM Nuvem 2TB, TIM Segurança Digital, Reforça Premium, Band News, Band Sports e Apps Redes Sociais.')]");
	}
			// ######## FIDELIZAÇÃO DO APARELHO ########
			public void clickMultiD3_0SemFid() throws InterruptedException {
				clicarXpath("//ion-radio/button/span");
			}

	public void clicBotaoTimBlackMulti() throws InterruptedException {
		clicarXpath("//button[contains(.,'Próximo')]");
	}

	// ############################################################
	
		
	// ######## POPUP E BOTÃO PROXIMO ########

	public void clickPopup() throws InterruptedException {
		clicarXpath("//button[contains(.,'OK')]");
	}
	
	public void clickPopupFim() throws InterruptedException {
	    Thread.sleep(5000);
		clicarXpath("//button[contains(.,'FIM')]");
	}
	
	public void clickPopupSim() throws InterruptedException {
	    Thread.sleep(5000);
		clicarXpath("//span[contains(.,'Sim')]");
	}
	
	public void clickPopupNao() throws InterruptedException {
	    Thread.sleep(5000);
        clicarXpath("//span[contains(.,'Não')]");
    }
	
	public void clickBotaoProx() throws InterruptedException {
	    Thread.sleep(5000);
        clicarXpath("//span[contains(.,'Próximo')]");
        
    }

	public void clickBotaoPlano() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]");
		Thread.sleep(10000);
	}
	
	public void poupupEstouCiente() throws InterruptedException {
        clicarXpath("//span[contains(.,'Estou Ciente')]");
    }
	
	
	public void poupupEndereco() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ion-alert/div/div[3]/button");
    }
	

	// ########################################################
		
	
	// ######## RESUMO DA OPERAÇÃO ########

	public void checkCiente() throws InterruptedException {
		Thread.sleep(8000);
		clicarXpath("//ion-card[2]/ion-card-content/ion-item/ion-checkbox/button/span");
	}

	public void clickCriarPedido() throws InterruptedException {
		clicarXpath("//span[contains(.,'Criar Pedido')]");
		Thread.sleep(35000);
	}
	
	public void clickClienteCienteMapa() throws InterruptedException {
        clicarXpath("/html/body/ion-app/ng-component/ion-nav/page-operation-summary/ion-content/div[2]/div/ion-card[2]/ion-card-content/ion-item/ion-checkbox/button/span");
    }

	public void clickCriarPedidoComDoc() throws InterruptedException {
		clicarXpath("//span[contains(.,'Criar Pedido com Documentação')]");
		Thread.sleep(35000);
	}

	// ########################################################
	

	// ######## SERVIÇO ########

	public void clickBotaoNetflix() throws InterruptedException {
		Thread.sleep(5000);
		clicarXpath("//ion-item[@id='service-Netflix Padrão']/div/div/ion-label/h1");
	}

	public void clickBotaoHBO() throws InterruptedException {
	    Thread.sleep(5000);
		clicarXpath("//*[@id=\"service-HBO Max\"]/div[1]/div");
	}

	public void clickBotaoYoutube() throws InterruptedException {
		clicarXpath("//ion-item[@id='service-YouTube Premium']/div/div/ion-label");
	}

	public void clickBotaoProsseguir() throws InterruptedException {
	    clicarXpath("//span[contains(.,'Próximo')]");
		Thread.sleep(5000);
	}

	// ########################################################
	
	
	// ######## DADOS DA ALÇADA - UPLOAD DE ARQUIVOS ########
		
	public void anexarIdentFrente() throws InterruptedException {
		Thread.sleep(8000);
		JavascriptExecutor js;
		js = (JavascriptExecutor)getDriver();
		WebElement element = getDriver().findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\T3666975\\Id_Frente.PNG");
	}
	
	public void anexarIdentVerso() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js;
		js = (JavascriptExecutor)getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//input[@type='file'])[2]"));
		element.sendKeys("C:\\Users\\T3666975\\Id_Verso.PNG");
	}

	public void anexarCPF() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js;
		js = (JavascriptExecutor)getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//input[@type='file'])[3]"));
		element.sendKeys("C:\\Users\\T3666975\\CPF.PNG");
	}

	public void anexarComprovanteRes() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js;
		js = (JavascriptExecutor)getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//input[@type='file'])[4]"));
		element.sendKeys("C:\\Users\\T3666975\\comprovante.PNG");
	}

	public void clickBotaoAlcada() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]	");
	}

	// ########################################################
		

	// ######## CARTÃO DE CRÉDITO ########

	public void setNumeroCartao(String numcartao) throws InterruptedException {
		Thread.sleep(10000);
		escreverComDoisIframes("//input", numcartao);
	}

	public void clickMesValidade() throws InterruptedException {
		clicarBotaoIframe("//select[@id='cardExpirationMonth']");
	}

	public void escolhaMesValidade() throws InterruptedException {
		clicarBotaoIframe("//option[@value='11']");
	}

	public void clickAnoValidade() throws InterruptedException {
		clicarBotaoIframe("//select[@id='cardExpirationYear']");
	}

	public void escolhaAnoValidade() throws InterruptedException {
		clicarBotaoIframe("//option[@value='2023']");
	}

	public void setCodSeguranca(String codseg) throws InterruptedException {
		escreverComDoisIframes("//input[@id='cardCvv']", codseg);
		Thread.sleep(5000);
	}

	public void clickConfPagamento() throws InterruptedException {
	    clicarBotaoIframe("//buton[contains(.,'Confirmar pagamento')]");
		Thread.sleep(30000);
	}

	// ########################################################
		

	// ######## ESCOLHER TITULAR OU DEPENDENTE ########

	public void escolhaTitular() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//ion-col[contains(.,'Titular')]");
	}

	public void escolhaDependente() throws InterruptedException {
	    Thread.sleep(2000);
		clicarXpath("//ion-col[contains(.,'Dependente')]");
	}

	public void numeroTitular(String numtitular) throws InterruptedException {
		escreverSemTroca("//input[@type='tel']", numtitular);
	}

	public void clickBotaoTitDep() throws InterruptedException {
		clicarXpath("//span[contains(.,'Próximo')]");
		Thread.sleep(10000);
	}

	public void clickMotivo1() throws InterruptedException {
		Thread.sleep(10000);
		clicarXpath("//ion-label[contains(.,'Motivo 1')]");
	}


	// ########################################################


	// ######## BARRA DE ROLAGEM - ROLAR PARA BAIXO ########
	//NÃO ESTÁ FUNCIONANDO
	public void rolarAteObject() throws InterruptedException {
	WebElement clickable = getDriver().findElement(By.xpath("//ion-radio/button/span"));
    new Actions(getDriver())
            .click(clickable)
            .perform();
  //NÃO ESTÁ FUNCIONANDO
    WebElement hoverable = getDriver().findElement(By.xpath("//ion-radio/button/span"));
    new Actions(getDriver())
            .moveToElement(hoverable)
            .perform();
	}
	
	// ########################################################
    

    // ######## GERAÇÃO DE PROTOCOLO ########

    public void escolhaTimControleSmartFlex_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-col[contains(.,'Titular')]");
    }

    public void clickMotivo1_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-select/button/span");
    }
    
    public void escolhaMotivo1_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }
    
    public void clickMotivo2_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-item[2]/div/div/ion-select/button/span");
    }
    
    public void escolhaMotivo2_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }
    
    public void clickMotivo3_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-item[3]/div/div/ion-select/button/span");
    }
    
    public void escolhaMotivo3_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }
    
    public void clickMotivo4_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-item[4]/div/div/ion-select/button/span");
    }
    
    public void escolhaMotivo4_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Não Informado')]");
    }
    
    public void clickResultado_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-card[2]/ion-card-content/ion-item/div/div/ion-select/button/span");
    }
    
    public void escolhaResultado_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Chamado aberto')]");
    }

    public void clickMeioDeContato_NovoProtocolo() throws InterruptedException {
        clicarXpath("//ion-card[2]/ion-card-content/ion-item[2]/div/div/ion-select/button/span");
    }
    
    public void escolhaMeioDeContato_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'E-mail')]");
    }

    public void clickObservacao_NovoProtocolo() throws InterruptedException {
        clicarCSS(".text-input");
    }
    
    public void setObservacao_NovoProtocolo(String protocolo) throws InterruptedException {
        escreverSemTroca("//textarea", protocolo);  
    }
    
    public void proximo_NovoProtocolo() throws InterruptedException {
        clicarXpath("//span[contains(.,'Próximo')]");
    }


    // ########################################################
    
 // ######## BUSCA PROTOCOLO - GET ########
    
    public String ResgataProtocolo() throws InterruptedException {
        return obterTextoXpath("/html/body/ion-app/ng-component/ion-nav/page-protocol-generated/ion-content/div[2]/ion-card[1]/ion-card-content/ion-item/div[1]/div");
    }
    

}







