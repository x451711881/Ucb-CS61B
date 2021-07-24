public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if(i>=0 && i <=127){
                if (!Flik.isSameNumber(i, j)) {

                    throw new Exception(
                            String.format("i:%d not same as j:%d ??", i, j));
                }
            }else if(i>=128 && i<=383){
                if (!Flik.isSameNumber((i-256), (j-256))){

                    throw new Exception(
                            String.format("i:%d not same as j:%d ??", i, j));
                }
            }else{
                if (!Flik.isSameNumber((i-512), (j-512))){

                    throw new Exception(
                            String.format("i:%d not same as j:%d ??", i, j));
                }
            }

        }
        System.out.println("i is " + i);
    }
}
