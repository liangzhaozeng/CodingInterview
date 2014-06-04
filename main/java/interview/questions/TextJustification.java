package interview.questions;

import java.util.ArrayList;

public class TextJustification {

	public ArrayList<String> fullJustify(String[] words, int L) {
		int wordsCount = words.length;
		ArrayList<String> result = new ArrayList<String>();
		int curLen = 0;
		int lastI = 0;
		for (int i = 0; i <= wordsCount; i++) {
			if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
				StringBuffer buf = new StringBuffer();
				int spaceCount = L - curLen;
				int spaceSlots = i - lastI - 1;
				if (spaceSlots == 0 || i == wordsCount) {
					for (int j = lastI; j < i; j++) {
						buf.append(words[j]);
						if (j != i - 1)
							appendSpace(buf, 1);
					}
					appendSpace(buf, L - buf.length());
				} else {
					int spaceEach = spaceCount / spaceSlots;
					int spaceExtra = spaceCount % spaceSlots;
					for (int j = lastI; j < i; j++) {
						buf.append(words[j]);
						if (j != i - 1)
							appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
					}
				}
				result.add(buf.toString());
				lastI = i;
				curLen = 0;
			}
			if (i < wordsCount)
				curLen += words[i].length();
		}
		return result;
	}

	private void appendSpace(StringBuffer sb, int count) {
		for (int i = 0; i < count; i++)
			sb.append(' ');
	}

	
	
	public static void main(String[] args) {  
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};  
//      String[] words = {""};  
//      String[] words = {"What","must","be","shall","be."};  
//     String[] words = { "" };  
       int L = 16;  
       System.out.println(fullJustify2(words, L));  
   }  
	public static ArrayList<String> fullJustify2(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		int wordsLen = words.length; // 单词数组的长度
		int curWordIdx = 0; // 处理第i个单词
		while (curWordIdx < wordsLen) { // 处理完所有单词后退出
			int charLen = 0; // 当前行累积的字符数量
			int probeWordIdx = curWordIdx;
			while (probeWordIdx < wordsLen && charLen + words[probeWordIdx].length() <= L) { // 贪婪加入尽可能多的单词
				charLen += ((words[probeWordIdx++]).length() + 1); // 累积单词长度和至少要有一个空格
			}
			if (probeWordIdx - curWordIdx == 1) { // tmpWordIdx-curWordIdx:
													// 该行放入单词的数目，如果只有一个单词要特殊处理
				String tmp = words[curWordIdx]; // 唯一的那个单词
				tmp = addSpace(tmp, L - words[curWordIdx].length()); // 那个单词后面都接上空格
				ret.add(tmp);
				curWordIdx = probeWordIdx; // 更新curWordIdx，因为已经处理好当前行了
				continue;
			}

			// tmpWordIdx-curWordIdx: 该行放入单词的数目，也就是紧接的空格的数量（因为每个单词后接一个空格）
			// wordCharLen：当前行所有由单词组成的字符数量（不包括空格）
			int wordCharLen = charLen - (probeWordIdx - curWordIdx);
			// meanSpace: 平均每个单词后的空格,tmpWordIdx<wordsLen 表示不是最后一行
			int meanSpace = probeWordIdx < wordsLen ? (L - wordCharLen) / (probeWordIdx - curWordIdx - 1) : 1;
			// leftSpace: 多余的空格
			int leftSpace = probeWordIdx < wordsLen ? (L - wordCharLen) % (probeWordIdx - curWordIdx - 1) : L
					- wordCharLen - (probeWordIdx - curWordIdx - 1);
			String tmp = new String();
			for (int k = curWordIdx; k < probeWordIdx - 1; k++) { // 对当前行最后一个单词特殊处理
				tmp += words[k];
				tmp = addSpace(tmp, meanSpace);
				if (probeWordIdx < wordsLen && leftSpace > 0) { // 因为居中对齐
					tmp += " ";
					leftSpace--;
				}
			}
			tmp += words[probeWordIdx - 1]; // 处理当前行的最后一个单词
			if (leftSpace > 0) { // 因为左对齐，所以在最后补上剩下的空格
				tmp = addSpace(tmp, leftSpace);  // only for last one
			}
			ret.add(tmp);
			curWordIdx = probeWordIdx; // 处理下一行的要处理的单词
		}
		return ret;
	}

	public static String addSpace(String s, int count) {
		for (int i = 1; i <= count; i++) {
			s += " ";
		}
		return s;
	}

}
