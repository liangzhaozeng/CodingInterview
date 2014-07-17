package algorithm.basic;

import java.util.BitSet;

public class BitSetOperation {





	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
		int[] shu={2,42,5,6,6,18,33,15,25,31,28,37};
		BitSet bm1=new BitSet(getMaxValue(shu));
		System.out.println("bm1.size()--"+bm1.size());
		
		putValueIntoBitSet(shu, bm1);
		printBitSet(bm1);
	}
	
	//初始全部为false，这个你可以不用，因为默认都是false
	public static void initBitSet(BitSet bs){
		for(int i=0;i<bs.size();i++){
			bs.set(i, false);
		}
	}
	//打印
	public static void printBitSet(BitSet bs){
		StringBuffer buf=new StringBuffer();
		buf.append("[\n");
		for(int i=0;i<bs.size();i++){
			if(i<bs.size()-1){
				buf.append(getBitTo10(bs.get(i))+",");
			}else{
				buf.append(getBitTo10(bs.get(i)));
			}
			if((i+1)%8==0&&i!=0){
				buf.append("\n");
			}
		}
		buf.append("]");
		System.out.println(buf.toString());
	}
	//找出数据集合最大值
	public static int getMaxValue(int[] zu){
		int temp=0;
		temp=zu[0];
		for(int i=0;i<zu.length;i++){
			if(temp<zu[i]){
				temp=zu[i];
			}
		}
		System.out.println("maxvalue:"+temp);
		return temp;
	}
	//放值
	public static void putValueIntoBitSet(int[] shu,BitSet bs){
		for(int i=0;i<shu.length;i++){
			bs.set(shu[i], true);
		}
	}
	//true,false换成1,0为了好看
	public static String getBitTo10(boolean flag){
		String a="";
		if(flag==true){
			return "1";
		}else{
			return "0";
		}
	}
	
	public static void test() {
	    BitSet bs = new BitSet();
	    bs.set(31);
	    bs.set(15);
	    bs.set(18);
	    int[] intArray = bits2Ints(bs);

	    for (int i = 0; i < intArray.length; i++)
	      System.out.println(toBinary(intArray[i]));
	  }

	  static int[] bits2Ints(BitSet bs) {
	    int[] temp = new int[bs.size() / 32];

	    for (int i = 0; i < temp.length; i++)
	      for (int j = 0; j < 32; j++)
	        if (bs.get(i * 32 + j))
	          temp[i] |= 1 << j;

	    return temp;
	  }

	  static String toBinary(int num) {
	    StringBuffer sb = new StringBuffer();

	    for (int i = 0; i < 32; i++) {
	      sb.append(((num & 1) == 1) ? '1' : '0');
	      num >>= 1;
	    }

	    return sb.reverse().toString();
	  }


}
