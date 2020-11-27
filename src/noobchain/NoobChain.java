package noobchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args) {
		
//		// ������ ������ ������ �ñ״�ó�� ���µ� �� �ñ״�ó�ȿ��� ����� ������ ���� ����� �ñ״�ó�� ����� ��
//		Block firstBlock = new Block("Hi Im The First Block", "0");
//		System.out.println("Block1:"+ firstBlock.hash);
//		
//		Block secondBlock = new Block("Yo, Im The Second Block", firstBlock.hash);
//		System.out.println("Block2:" + secondBlock.hash);
//		
//		Block thirdBlock = new Block("Hey, Im The Third Block", secondBlock.hash);
//		System.out.println("Block3:" + thirdBlock.hash);
		
		blockchain.add(new Block("Hi Im The First Block", "0"));
		blockchain.add(new Block("Yo, Im The Second Block", blockchain.get(blockchain.size()-1).hash));
		blockchain.add(new Block("Hey, Im The Third Block", blockchain.get(blockchain.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJson);
		
		
	}
	
	
}
