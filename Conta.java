public class Conta{
    public long numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    private double saque;
    
    
    public Conta(long numConta, String tipo, String dono, double saldo, boolean status, double saque){ 
        this.numConta = numConta;
        this.tipo=tipo;
        this.dono=dono;
        this.saldo = saldo;
        this.status = status;
        this.saque=saque;
    }
    
    public void abrirConta(String Tipo){
      this.tipo= tipo;
      status=true; 
     System.out.println("conta aberta"); 
     if(tipo.equals("cc")){
         this.setSaldo(50);
         System.out.println("saldo inicial de 50 reais"); 
     }
     else if(tipo.equals("cp")){
         System.out.println("saldo inicial de 150 reais"); 
     }
    }
    public void fecharConta(){
      if(saldo != 0){
          System.out.println("não pode fechar uma conta com saldo ou dividas");
      }
      else if(saldo == 0){
          status=false;
          System.out.println("conta fechada");
      }
    }
    public void depositar(double v){
        if(status == true && v>0){
            saldo += v;
            System.out.println("deposito bem sucedido! seu saldo aumentou para:"+ saldo+" reais");
        }
        else if(status == true && v==0){
            System.out.println("não é possivel depositar valores nulos");
        }
        else if(status == true && v<0){
            System.out.println("não é possivel depositar valores negativos");
        }
        else{
          System.out.println("não foi possivel depositar pois sua conta está fechada");
        }
    }
    public void sacar(double v){
         if(status == true && saldo > saque){
           saldo -= v;
           if(saldo > 0){
           System.out.println("saque sucedido!, seu saldo atual é: "+ saldo+ " reais");}
           else if(saldo == 0){
            System.out.println("saque sucedido! todo o saldo foi sacado, atencão ao limite de saldo!, saldo atual:"+saldo+" reais");
           }
           else{
            System.out.println("saque sucedido!, atenção: seu saldo está negativo, saldo atual: "+ saldo+" reais");
           }
        }
        else if(status == false && saldo < saque){
          System.out.println("não foi possivel sacar pois sua conta está fechada e não tem saldo sulficiente");
        }
        else if(status ==true){
            System.out.println("não foi possivel sacar pois não tem saldo suficiente");
        }
        else{
            System.out.println("não foi possivel sacar pois sua conta está fechada");
        } 
    }
    public void pagarMensal(){
        if(tipo.equals("cc")){
            saldo -= 12;
        }
        if(tipo.equals("cp")){
            saldo -= 20;
        }
    }
    
    public long getnumConta(){
        return numConta;  
    }
    public void setnumConta(long numConta){
        this.numConta= numConta;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getDono(){
        return dono;
    }
    public void setDono(String dono){
        this.dono = dono;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo= saldo;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

   public static void main(String[] args){
    Conta cliente = new Conta(635352,"cc","Davi",70,true,0);
    
  
  cliente.depositar(65.0);
  
    System.out.println("seu número da conta é: "+cliente.getnumConta());
    System.out.println("seu tipo de Conta é: "+cliente.getTipo());
    System.out.println("seu nome na conta é: "+cliente.getDono());
    System.out.println("seu saldo é: "+cliente.getSaldo()+ " reais");
    System.out.println("seu status da conta é: "+cliente.getStatus());
    cliente.abrirConta("cc");
    cliente.sacar(70.0);
   
   
    
}


}
