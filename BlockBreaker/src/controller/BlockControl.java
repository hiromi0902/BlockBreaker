package controller;

import model.BlockBean;
import model.BlockModel;
import view.BlockView;

public class BlockControl extends Thread{

	BlockModel BModel;
	BlockView BView ;
	BlockBean BBean ;

	public BlockControl(BlockView v) {
		this.BView = v;//このクラスのビューに引数1の情報を代入
		this.BBean = BView.getImageInfo();//このクラスのビーンにビューが保持しているビーンの情報を代入
		this.BModel = new BlockModel();//このクラスのモデルをインスタンス生成

	}
	//スレッド処理開始
	public void startSrocessing() {

	try {
		BView.drawingProcess(BBean);
		Thread.sleep(100);

		//無限ループ
		while(true){
			BBean = BView.getImageInfo();
			BBean = BModel.blockJudge(BBean);
			BView.setImageInfo(BBean);
			BView.drawingProcess(BBean);
			//1
			if(BBean.getBlocks()==0) {
				BBean.setBlockStatus(3);
				BView.gameClear();
			}
			//2
			else if(BBean.getBlockStatus()==2) {
				BView.gameClear();
				Thread.sleep(BBean.getRewriteSpeed());
			}
	}


	} catch (InterruptedException e) {
		//InterruptedExceptionのキャッチ実装
	}

	}

}



