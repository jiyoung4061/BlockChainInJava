package noobchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args) {
		
//		// 각각의 블럭들은 각자의 시그니처를 갖는데 이 시그니처안에는 블락의 정보와 이전 블락의 시그니처가 기반이 됨
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
