package EX5;

/**
 * A comparação entre String e StringBuffer demonstra que StringBuffer é mais eficiente em operações de concatenação.
 * A eficiência do StringBuffer decorre de sua capacidade de modificar o objeto original diretamente usando o método append(),
 * evitando a criação de objetos temporários. Em contraste, a String, sendo imutável, necessita criar um novo objeto a cada concatenação,
 * o que resulta em maior consumo de recursos e tempo de execução.
 * 
 * Este código mede o tempo de concatenação usando nanoTime() para evidenciar essa diferença de desempenho.
 */


public class Adaptor
{
    private String string1;
    private StringBuffer stringBuf1;

    private long time;

    public Adaptor(String string1, StringBuffer stringBuf1)
    {
        time = System.nanoTime();
        this.string1 = string1;
        this.stringBuf1 = stringBuf1;
    }

    public long getTime()
    {
        return time;
    }

    public String catString()
    {
        return string1 + "- parte dois";
    }

    public StringBuffer catStringBuf()
    {
        return stringBuf1.append("- parte dois");
    }

    public static void main(String[] args)
    {
    	Adaptor testing;
        long timeString, timeStringBuf;
        String str = new String("parte um ");
        StringBuffer strBuf = new StringBuffer("parte um ");
        testing = new Adaptor(str, strBuf);
        testing.catString();
        timeString = System.nanoTime() - testing.getTime();
        testing = new Adaptor(str, strBuf);
        testing.catStringBuf();
        timeStringBuf = System.nanoTime() - testing.getTime();
        System.out.println("Time taken in concatenation is:\n\tString:    " + timeString + " ns\n\tStringBuf:  "
                + timeStringBuf + " ns");
    }
}
