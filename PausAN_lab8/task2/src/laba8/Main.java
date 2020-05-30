//https://github.com/AnastasiyaPaus28/AiSD
package laba8;

public class Main {

    public static void main(String[] args) {
        Tree Tfirst=new Tree();
        Tfirst.add(8);
        Tfirst.add(4);
        Tfirst.add(10);
        Tfirst.add(1);
        Tfirst.add(6);
        Tfirst.add(14);
        Tfirst.add(2);
        Tfirst.add(7);
      // bstF.add(9);
        Tfirst.add(13);
        Tfirst.print();

        Tree Tsecond=new Tree();
        Tsecond.add(8);
        Tsecond.add(4);
        Tsecond.add(10);
        Tsecond.add(1);
        Tsecond.add(6);
        Tsecond.add(14);
        Tsecond.add(2);
        Tsecond.add(7);
        Tsecond.add(13);
        Tsecond.print();
        FunZ(Tfirst,Tsecond);


    }
    static boolean FunZ(Tree first, Tree second){
        String[] OneN= first.PrObhod(first.getRoot()).split(" ");
        String[] TwoN= second.PrObhod(second.getRoot()).split(" ");

        Tree FirTree;
        Tree SeTree;
        int key1,key2;

        FirTree=new Tree();addNs(FirTree,OneN);
        SeTree=new Tree();addNs(SeTree,TwoN);
        for (int i = 0; i < OneN.length; i++) {       
        key2=Integer.parseInt( OneN[0]);
        FirTree.RightDelete(key2);
        System.out.println("1 корень удален");
        FirTree.print();
        break;
        }         
        for (int i = 0; i < TwoN.length; i++) {
        	key1=Integer.parseInt( TwoN[0]);
        	SeTree.RightDelete(key1);
        	 System.out.println("2 корень удален");
        	 SeTree.print();
        	 break;
        }
        if(FirTree.Zerkalo(SeTree.getRoot())) {
        	System.out.println("Они равны по структуре");
        	System.out.println("Прямой обход:");
        	 FirTree.stTr();        	 
         	SeTree.stTr();
         	
        return true;
        }
        else { System.out.println("Они разные по структуре");
        System.out.println("Прямой обход:");
        FirTree.stTr();
        	SeTree.stTr();
        return false;
        }
       
    }
    
    static void addNs(Tree tree, String[] nodes){
        if(!nodes[0].equals(""))
            for(String str: nodes)
                tree.add(Integer.parseInt(str));

    }
}
