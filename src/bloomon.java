class bloomon{
    public static void main(String[] ss){
        BufferedReader br=new BufferedReader(new FileReader("../code-challenge-production-master/sample/input.txt"));
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