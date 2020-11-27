package noobchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
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
		
//		// json 형태로 보는 블록체인의 각 블럭들
//		blockchain.add(new Block("Hi Im The First Block", "0"));
//		blockchain.add(new Block("Yo, Im The Second Block", blockchain.get(blockchain.size()-1).hash));
//		blockchain.add(new Block("Hey, Im The Third Block", blockchain.get(blockchain.size()-1).hash));
//		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//		System.out.println(blockchainJson);
//		
		// 마이닝하기
		blockchain.add(new Block("Hi Im The First Block", "0"));
		System.out.println("Trying to Min block 1...");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo, Im The Second Block", blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Min block 2...");
		blockchain.get(1).mineBlock(difficulty);
				
		blockchain.add(new Block("Hey, Im The Third Block", blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Min block 3...");
		blockchain.get(2).mineBlock(difficulty);
		
		System.out.println("\n BlockChain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe Block Chain: ");
		System.out.println(blockchainJson);
		
	}
	
	public static Boolean isChainValid() { 
		Block currentBlock;
		Block previousBlock;
		
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		for(int i = 1 ; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) { //현재 블럭 해시값 비교하기
				System.out.println("Current Hashes not equal");
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash)) { // 이전블럭 해시값 비교하기
				System.out.println("Previous Hashes not equal");
				return false;
			}
			
			// 마이닝에 의해 해결된 해쉬값을 갖고있는지 체크 (추가된 부분)
			if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block has not been mined!");
				return false;
			}
		}
		return true;
	}
}
