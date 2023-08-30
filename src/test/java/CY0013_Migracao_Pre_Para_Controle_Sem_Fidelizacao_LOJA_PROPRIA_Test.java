import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.wcaquino.pages.Cenarios_TelasPage;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.utils.DataBaseUtils;
import br.ce.wcaquino.utils.JenkinsHelper;

public class CY0013_Migracao_Pre_Para_Controle_Sem_Fidelizacao_LOJA_PROPRIA_Test extends Cenarios_TelasPage{
	
	private Cenarios_TelasPage cenariostelas = new Cenarios_TelasPage();
	private static LoginPage page = new LoginPage();
	private DataBaseUtils database = new DataBaseUtils();
	private String ResgataRowId = "Select * from siebel.cx_interf_log  "
            + "where event_name like '%SOA419%' and key_1 = '$CPF' and key_3 = '$Protocolo' "
            + "and error_message  = 'Sucesso' and status = 'OK' "
            + "ORDER BY CREATED DESC ";
    
    private String ResgataCPF = "Select distinct prd.name,prd.part_num,prd.category_cd,prd.desc_text,ext.alias_name,ext.name as cpf,ext.X_TIPO_CLIENTE,ass.asset_num,ass.created,prd.name "
            + "from siebel.s_asset ass, "
            + "siebel.s_org_ext ext, "
            + "siebel.s_Prod_int prd, "
            + "siebel.s_asset assp "
            + "where ass.status_cd = 'Ativo' "
            + "and assp.status_cd = 'Ativo' "
            + "and ext.alias_name not like 'DADOS EM ENRIQUECIMENTO' "
            + "and ext.alias_name not like 'Teste FQA' "
            + "and ass.asset_num like '15%' "
            + "and ass.owner_accnt_id = ext.row_id "
            + "and assp.prod_id = prd.row_id "
            + "and ass.row_id = ass.root_asset_id "
            + "and assp.root_asset_id = ass.row_id "
            + "and prd.part_num = 'PLANOPREMOVEL' "
            + "and prd.desc_text like '%PRÉ TOP%' "
            + "and not exists (select 1 from siebel.s_order ord where ord.status_cd in ('Erro no Cancelamento', "
            + "'Pendente', "
            + "'Pendente Portabilidade', "
            + "'Aguardando Aprovação', "
            + "'Aberto', "
            + "'Cancelled', "
            + "'Erro no Aprovisionamento', "
            + "'Fechado', "
            + "'Pendente Cancelamento', "
            + "'Erro no Provisionamento', "
            + "'Pendente Aprovação Master', "
            + "'Pendente de Envio', "
            + "'Em Processamento', "
            + "'Em aprovisionamento', "
            + "'Reaberto', "
            + "'Aguardando Cancel Entrega', "
            + "'Aguardando Liberação', "
            + "'Aguardando pagamento', "
            + "'Aguardando Aceite', "
            + "'Aguardando Agendamento', "
            + "'Aguardando aprovação', "
            + "'Enviado para o Pré-Pago', "
            + "'Aguardando Pagamento CC', "
            + "'Abrir', "
            + "'Aberta', "
            + "'Em Cancelamento', "
            + "'Provision', "
            + "'Aguardando', "
            + "'Aguardando Aprovação Alçada', "
            + "'Cancelada', "
            + "'Em Aprovisionamento') "
            + "and ord.ACCNT_ID = ass.owner_accnt_id) "
            + "order by ass.created desc ";
    
    private String Resgata_Protocolo_Perroni = "SELECT A.key_3 AS PROTOCOLO "
            + ",A.key_1 AS CPF "
            + ",A.CREATED AS SOA_419_DATE "
            + ",I.CREATED AS ORDER_CREATION_DATE "
            + ",ROUND((I.CREATED - A.CREATED) * 24 * 60 * 60) AS ORDER_CREATION_TIME "
            + ",ROUND((I.LAST_UPD - I.CREATED) * 24 * 60 * 60) AS ORDER_PROVISIONING_TIME "
            + ",A.ERROR_CODE AS ERROR_CODE "
            + ",A.ERROR_MESSAGE AS ERROR_MESSAGE "
            + ",B.QUOTE_NUM AS QUOTE_ID "
            + ",C.X_Q2O_STATUS AS QUOTE_STATUS "
            + ",M.X_NOTAS_ATV AS NOTA "
            + ",C.SERVICE_NUM AS MSISDN "
            + ",C.X_STATUS_REASON_VAREJO AS STATUS_REASON "
            + ",I.ORDER_NUM AS ORDER_NUM "
            + ",I.STATUS_CD AS ORDER_STATUS "
            + ",A.xml_external AS XML "
            + ",N.MSG AS GENERIC_ERROR_DETAIL "
            + "FROM SIEBEL.CX_INTERF_LOG A "
            + ",SIEBEL.S_DOC_QUOTE B "
            + ",("
            + "SELECT A1.* "
            + "FROM SIEBEL.S_QUOTE_ITEM A1 "
            + ",SIEBEL.S_DOC_QUOTE B1\r\n"
            + ",SIEBEL.CX_INTERF_LOG C1\r\n"
            + "WHERE C1.EVENT_NAME = 'SOA419' "
            + "AND B1.INTEGRATION_ID = C1.KEY_2 "
            + "AND A1.SD_ID = B1.ROW_ID "
            + "AND A1.ROW_ID = A1.ROOT_QUOTE_ITEM_ID "
            + ") C "
            + ",( "
            + "SELECT D1.* "
            + ",A1.SD_ID "
            + "FROM SIEBEL.S_QUOTE_ITEM A1 "
            + ",SIEBEL.S_DOC_QUOTE B1 "
            + ",SIEBEL.CX_INTERF_LOG C1 "
            + ",SIEBEL.S_PROD_INT D1 "
            + "WHERE C1.EVENT_NAME = 'SOA419' "
            + "AND B1.INTEGRATION_ID = C1.KEY_2 "
            + "AND A1.SD_ID = B1.ROW_ID "
            + "AND D1.ROW_ID = A1.PROD_ID "
            + "AND D1.CATEGORY_CD = 'PLANO' "
            + ") D "
            + ",SIEBEL.S_PROD_INT E "
            + ",SIEBEL.S_INV_PROF F "
            + ",SIEBEL.CX_INTERF_LOG G "
            + ",SIEBEL.S_ORG_EXT H "
            + ",SIEBEL.S_ORDER I "
            + ",SIEBEL.S_EVT_ACT J "
            + ",SIEBEL.S_ACT_SR K "
            + ",SIEBEL.S_SRV_REQ L "
            + ",SIEBEL.S_EVT_ACT M "
            + ",SIEBEL.CX_ERR_HANDLING N "
            + "WHERE A.EVENT_NAME = 'SOA419' "
            + "AND B.INTEGRATION_ID(+) = A.KEY_2 "
            + "AND C.SD_ID(+) = B.ROW_ID "
            + "AND D.SD_ID(+) = B.ROW_ID "
            + "AND E.ROW_ID(+) = C.PROD_ID "
            + "AND F.ROW_ID(+) = C.BILL_PROFILE_ID "
            + "AND G.EVENT_NAME(+) = 'SOA206' "
            + "AND G.KEY_2(+) = F.ROW_ID "
            + "AND H.ROW_ID(+) = B.TARGET_OU_ID "
            + "AND I.QUOTE_ID(+) = B.ROW_ID "
            + "AND J.QUOTE_ITEM_ID(+) = C.ROW_ID "
            + "AND K.ACTIVITY_ID(+) = J.ROW_ID "
            + "AND L.ROW_ID(+) = K.SR_ID "
            + "AND M.SRA_SR_ID(+) = L.ROW_ID "
            + "AND M.TODO_CD(+) != 'SMS - Outbound' "
            + "AND N.OBJECT_ID(+) = A.ROW_ID "
            + "and a.row_id in ('$rowid') "
            + "ORDER BY A.CREATED DESC ";
	
	// ######## LOGAR NO SISTEMA ########
	@BeforeClass
	public static void inicializa() throws InterruptedException{
		//Abrindo Site/App
		page.acessarTelaInicial();
		//Logando com Matricula e Senha
		page.setEmail("T3313299");
		page.setSenha("Tim@12345");
		page.entrar();
	}


	// ######## IDENTIFICAÇÃO DE PDV ########
	@Test
	public void test_Migracao_Pre_Para_Controle_Sem_Fidelização_LOJA_PROPRIA() throws InterruptedException{
		cenariostelas.sendPDV("E A DUTRA"); 
		cenariostelas.EscolhaPDVDutra();
		cenariostelas.confirmaPDV();
		cenariostelas.fechapopupPDV();


	// ######## ESCOLHA O PRODUTO ########
		cenariostelas.escolherProduto();


	// ######## AMBIENTE DE ATENDIMENTO ########
		cenariostelas.clickAntesAtendimento();
		cenariostelas.clickAtendimento();
		cenariostelas.proximoAmbienteAtend();


	// ######## NOVO ATENDIMENTO ########
        Connection conn = DataBaseUtils.newSiebelPreUAT1Connection();
        ResultSet respCPF = database.executeAndReturnFirstResult(ResgataCPF, conn);
        String cpf = "";
        try {
            cpf = respCPF.getString(6);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } DataBaseUtils.closeConnection(conn);
        
        // ######## INSERIR CPF ########
        cenariostelas.setCPF(cpf);
                        
		// ######## INSERIR TELEFONE ########
        String telcont = "45581056811";
        cenariostelas.setTelefone(telcont);
        cenariostelas.proximoNovoAtendimento();
		

	// ######## ATENDIMENTO ########
		cenariostelas.clickTimPreTop();
		cenariostelas.proximoAtendimento();


	// ######## NO PÓS VENDA ########
		cenariostelas.clickMigracao();


	// ######## DADOS DO CLIENTE ########
		cenariostelas.setCEPTroca("03178030");
        cenariostelas.buscarCEP();
		cenariostelas.proximoDadosClientes();
		
		
	// ######## ENDEREÇO DO CLIENTE ########
        cenariostelas.clickVerificarTIMLIVE();
        cenariostelas.clickPopup();
        cenariostelas.clickTipoDeComplemento();
        cenariostelas.escolhaTipoDeComplemento();
        cenariostelas.clickComplemento();
        cenariostelas.setComplemento("401");
        cenariostelas.proximoEnderecoClientes();
        // ################################
        cenariostelas.clickPopup();
        

	// ######## MIGRACAO ########
		cenariostelas.clickPre_ControleFatura();


	// ######## PLANOS ########
		cenariostelas.clickPlanoTimControleAPlus50();
		cenariostelas.clickPlanoSemFidelizacao();
		cenariostelas.proximoDadosClientes();


	// ######## SERVIÇOS ########
		cenariostelas.clickBotaoProsseguir();


	// ######## INFORMAÇÃO DA FATURA ########
		cenariostelas.clickDataVencimento();
		cenariostelas.clickBotaoInfFatura();
		
		
	// ######## PÓS VENDA ########
		cenariostelas.clickFinalizar();	
		
		
	// ######## LIMPAR MASSA ########
		String msisdn = cenariostelas.ResgataMSISDN();
        System.out.print("DADOS DO CENÁRIO DE TESTE:" + "\n");
        System.out.print("CPF:" + cpf + "\n");
        System.out.print("TEL. CONTATO:" + telcont + "\n");
        System.out.print("MSISDN:" + msisdn + "\n");
        String res="";
        try {
            res = JenkinsHelper.runJk_Limpar_Massa(cpf, msisdn, "" );
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        System.out.print("RESULTADO DA LIMPEZA NO JENKINS:" + "\n" + res);


     // ######## RESUMO DA OPERAÇÃO ########
        cenariostelas.checkCiente();
        cenariostelas.clickCriarPedidoComDoc();
        //System.out.print("\n" + "Fim da Conexão com o Jenkins" + "\n");
        
        
    //############# EVIDÊNCIAS #############
        
        //############# EXECUÇÃO DA QUERY CPF_PROTOCOLO #############
        conn = DataBaseUtils.newSiebelUAT1Connection();
        String protocoloid = cenariostelas.ResgataProtocolo();
        String queryProtocolo = ResgataRowId.replace("$CPF",cpf).replace("$Protocolo", protocoloid);
        ResultSet resultProtocolo = database.executeAndReturnFirstResult(queryProtocolo, conn);
        String rowid = "";
        String error_code = "";
        String error_mensage = "";
        String event_name ="";
        
        try { 
        rowid = resultProtocolo.getString(1);
        error_code = resultProtocolo.getString(15);
        error_mensage = resultProtocolo.getString(16);
        event_name = resultProtocolo.getString(17);
        
        //############# RESULTADO DA QUERY CPF_PROTOCOLO #############
        System.out.println("\n" + "Dados da Query CPF_PROTOCOLO");
        System.out.print("ROW_ID : " + rowid + "\n");
        System.out.print("ERROR_CODE : " + error_code + "\n");
        System.out.print("ERROR_MENSAGE : " + error_mensage + "\n");
        System.out.print("EVENT_NAME : " + event_name);
            
        } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();}
        DataBaseUtils.closeConnection(conn);
        
      //############# EXECUÇÃO DA QUERY PERRONI #############
        conn = DataBaseUtils.newSiebelUAT1Connection();
        String queryResultado = Resgata_Protocolo_Perroni.replace("$rowid",rowid);
        ResultSet resultStatus = database.executeAndReturnFirstResult(queryResultado, conn);
        String errorcode = "";
        String errormensage = "";
        String quotestatus = "";
        String statusreason = "";
        String ordernum = "";
        String orderstatus = "";
        
        try { 
        errorcode = resultStatus.getString(7);
        errormensage = resultStatus.getString(8);
        quotestatus = resultStatus.getString(10);
        statusreason = resultStatus.getString(13);
        ordernum = resultStatus.getString(14);
        orderstatus = resultStatus.getString(15);
        
        //############# RESULTADO DA QUERY PERRONI #############
        System.out.print("Fim dos Dados da Query" + "\n");
        System.out.print("\n" + "Dados da Query_Perroni" + "\n");        
        System.out.print("ERROR_CODE : " + errorcode + "\n");
        System.out.print("ERROR_MENSAGE : " + errormensage + "\n");
        System.out.print("QUOTE_STATUS : " + quotestatus + "\n");
        System.out.print("STATUS_REASON : " + statusreason + "\n");
        System.out.print("ORDER_NUM : " + ordernum + "\n");
        System.out.print("ORDER_STATUS : " + orderstatus + "\n");
        System.out.print("Fim dos Dados da Query" + "\n");
        
        //################# DADOS DO TESTE #################
        System.out.print("\n" + "Dados do Teste" + "\n");
        System.out.print("CPF : " + cpf + "\n");
        System.out.print("PROTOCOLO : " + protocoloid + "\n");
        System.out.print("TEL. CONTATO : " + telcont + "\n");
        System.out.print("MSISDN : " + msisdn + "\n");
        //System.out.print("CHIP : " + chip);
                        
        } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();} 
        DataBaseUtils.closeConnection(conn);
        System.out.print("FIM");
        
    // ######## ENCERRA E FECHA JANELA ########
        cenariostelas.encerra();
    }   
}