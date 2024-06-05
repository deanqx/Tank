package Tank;

public class Tank
{
    private final int number;
    private String content;
    private int volumen = 0;
    private final int maxvol;
    
    public Tank(int number, String content, int maxvol)
    {
        this.number = number;
        this.content = content;
        this.maxvol = maxvol;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    // @returns True for error, no changes will be made: 0 > volumen > maxvol
    public boolean setVolumen(int volumen)
    {
        if (0 > volumen || volumen > maxvol)
        {
            return true;
        }
        
        this.volumen = volumen;
        return false;
    }
    
    public void increase()
    {
        volumen += maxvol * 100 / 20;
    }
    
    public void decrease()
    {
        volumen += maxvol * 100 / 20;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public int getVolumen()
    {
        return volumen;
    }
    
    public int getMaxvol()
    {
        return maxvol;
    }
    
    // TODO getter und setter
}
