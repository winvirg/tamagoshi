public class Tamagotchi {
    private int energiaMax;
    private int energia;
    private int saciedadeMax;
    private int saciedade;
    private int limpezaMax;
    private int limpeza;
    private int idadeMax;
    private int idade = 0;
    private int diamantes = 0;
    private boolean vivo = true;

    public Tamagotchi(int energiaMax, int saciedadeMax, int limpezaMax, int idadeMax){
        this.energiaMax = energiaMax;
        this.energia = energiaMax;
        this.saciedadeMax = saciedadeMax;
        this.saciedade = saciedadeMax;
        this.limpezaMax = limpezaMax;
        this.limpeza = limpezaMax;
        this.idadeMax = idadeMax;
        mostra();
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public int getEnergiaAtual() {
        return energia;
    }

    public void setEnergiaAtual(int valor){
        if(energia + valor >= energiaMax){
        	energia = energiaMax; 
        }else if(energia + valor <= 0){
        	energia = 0;
            vivo = false;
        }else{
        	energia += valor;
        }
        
    }

    public int getSaciedadeAtual() {
        return saciedade;
    }

    public void setSaciedadeAtual(int valor){
        if(saciedade + valor >= saciedadeMax){
        	saciedade = saciedadeMax; 
        }else if(saciedade + valor <= 0){
        	saciedade = 0;
            vivo = false;
        }else{
        	saciedade += valor;
        }
    }

    public int getLimpezaAtual() {
        return limpeza;
    }

    public void setLimpezaAtual(int valor){
        if(limpeza + valor >= limpezaMax){
        	limpeza = limpezaMax; 
        }else if(limpeza + valor <= 0){
        	limpeza = 0;
            vivo = false;
        }else{
        	limpeza += valor;
        }
    }

    public int getIdadeAtual() {
        return idade;
    }

    public void setIdadeAtual(int valor){
        if(idade + valor >= idadeMax){
            vivo = false;
            idade = idadeMax;
        }else{
        	idade += valor;
        }
    }

    public int getDiamantes() {
        return diamantes;
    }
    
    public void setDiamantes(int valor){
        diamantes += valor;
    }

    public boolean getEstaVivo(){
        return vivo;
    }

    public void morrendo(){
        vivo = false;
        mostra();
    }
    
    public boolean brincar(){
        if(!getEstaVivo()){
            mostra();
            return false;
        }else{
            setEnergiaAtual(-2);
            setSaciedadeAtual(-1);
            setLimpezaAtual(-3);
            setDiamantes(1);
            setIdadeAtual(1);
            mostra();
        }
        return true;
    }

    public boolean comer(){
        if(!getEstaVivo()){
            mostra();
            return false;
        }else{
            setEnergiaAtual(-1);
            setSaciedadeAtual(4);
            setLimpezaAtual(-2);
            setIdadeAtual(1);
            mostra();
        }
        return true;
    }

    public boolean dormir(){
        if(!getEstaVivo() || energia >= energiaMax-4){
            mostra();
            return false;
        }else{
            while(energia != energiaMax){
                setEnergiaAtual(1);
                setIdadeAtual(1);
            }
            setSaciedadeAtual(-2);
            mostra();
            return true;
        }
        
    }

    public boolean banhar(){
        if(!getEstaVivo()){
            mostra();
            return false;
        }else{
            setEnergiaAtual(-3);
            setSaciedadeAtual(-1);
            setLimpezaAtual(limpezaMax);
            setIdadeAtual(2);
            mostra();
        }
        return true;
    }

    public void mostra(){
        System.out.println("E:" + getEnergiaAtual() + "/" + getEnergiaMax() +
                ", S:" + getSaciedadeAtual() + "/" + getSaciedadeMax() + 
                ", L:" + getLimpezaAtual() + "/" + getLimpezaMax() +
                ", D:" + getDiamantes() + 
                ", I:" + getIdadeAtual() + "/" + getIdadeMax() +
                ", Vv: " + vivo);

    }
}
