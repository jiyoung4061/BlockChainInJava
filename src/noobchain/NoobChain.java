package noobchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
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
		
//		// json ���·� ���� ���ü���� �� ����
//		blockchain.add(new Block("Hi Im The First Block", "0"));
//		blockchain.add(new Block("Yo, Im The Second Block", blockchain.get(blockchain.size()-1).hash));
//		blockchain.add(new Block("Hey, Im The Third Block", blockchain.get(blockchain.size()-1).hash));
//		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//		System.out.println(blockchainJson);
//		
		// ���̴��ϱ�
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
			
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) { //���� �� �ؽð� ���ϱ�
				System.out.println("Current Hashes not equal");
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash)) { // ������ �ؽð� ���ϱ�
				System.out.println("Previous Hashes not equal");
				return false;
			}
			
			// ���̴׿� ���� �ذ�� �ؽ����� �����ִ��� üũ (�߰��� �κ�)
			if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block has not been mined!");
				return false;
			}
		}
		return true;
	}
}
