package istenilenyilintakvimi;
import java.util.Scanner;
public class IstenilenYilinTakvimi {

    public static void main(String[] args) {
        Scanner klavye=new Scanner(System.in);
        System.out.println("Lütfen bir yil girin: ");
        int yil=klavye.nextInt();
        
        boolean artikYil=isArtikYil(yil);
        
        if (artikYil)
        {
            System.out.println("Bir artik yildir");    
        }
        else
        {
            System.out.println("Bir artik yil değildir");
        }
        
        takvimiYazdir(yil);
        
        klavye.close();
        
    }
    public static boolean isArtikYil(int yil)
    {
        return (yil%4==0 && yil%100!=0) || (yil%400==0);
    }
    public static void takvimiYazdir(int yil)
    {
        System.out.println("\n"+yil+" YILININ TAKVİMİ");
        
        for (int ay=1;ay<=12;ay++)
        {
            System.out.println("\n"+ay+".Ay");
            
            System.out.println("Pzt Sal Çar Per Cum Cmt Paz");
            int gunSayisi = gunSayisiHesapla(yil, ay);
            
            int ilkGun = (gunGunuHesapla(yil, ay, 1)+6)%7;
            
            for(int i=0;i< ilkGun;i++)
            {
                System.out.println(" ");
            }
            for(int gun=1;gun<=gunSayisi;gun++)
            {
                System.out.printf("%3d", gun);
                if ((gun+ilkGun)%7 ==0)
                {
                    System.out.println();    
                }
            }
            System.out.println();
        }
    }
    public static int gunSayisiHesapla(int yil, int ay)
    {
        if (ay==2)
        {
        return isArtikYil(yil) ? 29:28;
        }
        else if (ay==4 || ay==6 || ay==9 || ay==11)
        {
        return 30;
        }
        else
        {
         return 31;
        }
    }
    public static int gunGunuHesapla(int yil,int ay,int gun)
    {
        if(ay<3)
        {
            ay +=12;
            yil--;
        }
        int h=(gun + 2* ay + (3 * (ay+1))/5+yil+yil/4-yil/100+yil/400)%7;
        return h;
    }
}
