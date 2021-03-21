package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import model.BlockBean;

public class BlockViewPanel extends Panel{

	//画像情報を保存するための変数：BlockBean
	private BlockBean imageInfo ;
	//オフスクリーングラフィックス：java.awt.Graphics
	private Graphics offScreenGaphics ;
	//オフスクリーンイメージ領域：java.awt.Image
	private Image offScreenImage ;

	//オフスクリーン用の描写領域を作成
	//@Override
	public void setBound(int x,int y,int width,int height) {
		//親クラスの境界セッター
		super.setBounds(x,y,width,height);
		//現在の画面幅取得
		int screenWidth = this.getWidth();
		//現在の画面高取得
		int screenHeight = this.getHeight();
		//描写領域作成
		offScreenImage = this.createImage(screenWidth,screenHeight);
		offScreenGaphics = offScreenImage.getGraphics();
	}

	//画像情報を渡して書き換え
	public void imageRewrite(BlockBean b) {
		imageInfo = b ;
		this.repaint();
	}

	//ダブルバッファを行う
	@Override
	public void update(Graphics g) {
		screenImageBean(g);
	}


	//画面情報Beanにしたがって描写
	public void screenImageBean(Graphics g) {
		//条①
		//オフスクリーン領域の描写を一旦消去する
		if(imageInfo!= null) {
			offScreenGaphics.clearRect(0,0,
					imageInfo.getBlockImageWidth(),
					imageInfo.getBlockImageHeight());

			//ボールの描写
			offScreenGaphics.drawImage(
					imageInfo.getBallImage(),
					imageInfo.getBallx(),
					imageInfo.getBally(),
					imageInfo.getBallWidth()*2,
					imageInfo.getBallHeight()*2,
					this);

			//カーソルの描写
			offScreenGaphics.drawImage(
					imageInfo.getRacketImage(),
					imageInfo.getRacketx(),
					imageInfo.getRackety(),
					imageInfo.getRacketWidth(),
					imageInfo.getRacketHeight(),
					this);

				for(int counter = 0 ; counter < imageInfo.getBlock().length ; counter++) {
					//条②
					if(imageInfo.getBlock()[counter]==1) {
						offScreenGaphics.drawImage(
								imageInfo.getBlockImage(),
								imageInfo.getBlockx()[counter],
								imageInfo.getBlocky()[counter],
								50,20,this);
				}
				}
					{
				offScreenGaphics.drawImage(offScreenImage,0,0,this);
					}
				}
				//条3
				else if(imageInfo.getBlocks()==0) {
					//クリア画面を描写
					Font font = new Font("Serif",Font.PLAIN,50);
					g.setFont(font);
					g.setColor(Color.blue.darker());
					g.drawString("クリアー",100,200);
				}
				//条4
				else if(imageInfo.getBlockStatus()==2) {
					//ゲームオーバー画面を描写
					Font font = new Font("Serif",Font.PLAIN,50);
					g.setFont(font);
					g.setColor(Color.blue.darker());
					g.drawString("ゲームオーバー",20,200);
				}

	}

	}









