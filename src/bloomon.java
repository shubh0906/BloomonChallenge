import java.io.*;
import java.util.*;
class bloomon{
    public static class Bouquet{
        Map<Character,Integer> flowers;
        String spec;
        char size;
        int extraFLowers;
        int sumOfFlowers;
        Bouquet(String spec){
            this.spec = spec;
            flowers = new HashMap<Character,Integer>();
            size = spec.charAt(1);
            sumOfFlowers = 0;
            for(int i=2;i<spec.length();i++){
                StringBuilder sb = new StringBuilder();
                while(i<spec.length()&&spec.charAt(i)>=48 && spec.charAt(i)<=57)
                    sb.append(spec.charAt(i++));
                if(i!=spec.length()){
                    flowers.put(spec.charAt(i),Integer.parseInt(sb.toString()));
                    sumOfFlowers+=Integer.parseInt(sb.toString());
                }
                else
                    extraFLowers = Integer.parseInt(sb.toString())-sumOfFlowers;
            }
        }

    }
    public static void main(String[] ss)throws Exception{
        List<Bouquet> bouquets = new ArrayList<Bouquet>();

        BufferedReader br=new BufferedReader(new FileReader("../sample/input.txt"));
        String line = "";
        while(!(line = br.readLine()).equals("")){
            bouquets.add(new Bouquet(line));
            System.out.println(line);
        }
        while((line = br.readLine())!=null){
            char size = line.charAt(1);
            char flowerType = line.charAt(0);
        }
    }
}