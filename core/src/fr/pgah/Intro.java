package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class Intro extends ApplicationAdapter {
  SpriteBatch batch; //définition et nom de la variable(bleu) type de la variable(vert)
  //Texture img; 
  Texture[] imgs;
  // int x;
  // int y; //objet commence par une maj et primitifs non 
  int[] coordonneesX;
  int[] coordonneesY;
  int[] hauteursImg;
  int[] largeursImg;
  int[] directionsEnX;
  int[] directionsEnY;
  int[] couleursDVD;
  int hauteurFenetre;
  int largeurFenetre;
  int hauteurImg;
  int largeurImg;
  int directionEnY; //defini de base a 0
  int directionEnX; 
  int couleurDVD;

  @Override
  public void create() { //instanciation des obj crées au dessus
    batch = new SpriteBatch(); // sans le new l'objet pointe vers null et va créer un erreur
    //img = new Texture("dvd.jpg");
    imgs = new Texture[2];
    imgs[0] = new Texture("dvd.png");
    imgs[1] = new Texture("dvdc.png");
    coordonneesX = new int[2];
    coordonneesY = new int[2];
    hauteursImg = new int[2];
    largeursImg = new int[2];
    directionsEnX = new int[2];
    directionsEnY = new int[2];
    couleursDVD = new int[2];
    coordonneesX[0] = 0; 
    coordonneesY[0] = 0;
    coordonneesX[1] = 400;
    coordonneesY[1] = 0;
    couleursDVD[0] = 0;
    couleursDVD[1] = 5;
    hauteurFenetre = Gdx.graphics.getHeight();
    hauteursImg[0] = imgs[0].getHeight();
    largeursImg[0] = imgs[0].getWidth();
    hauteursImg[1] = imgs[1].getHeight();
    largeursImg[1] = imgs[1].getWidth();
    largeurFenetre = Gdx.graphics.getWidth();
    directionsEnY[0] = 0;
    directionsEnX[0] = 0;
    directionsEnY[1] = 1;
    directionsEnX[1] = 0;
  }


  @Override
  public void render() {
    reinitialiserBackground(); //f2 pour renommer toutes les utilisations du nom dans le code
    defCouleurDVD();
    majcoordonnees();
    testBordures();
    batch.begin();
    batch.draw(imgs[0], coordonneesX[0], coordonneesY[0]);
    batch.draw(imgs[1], coordonneesX[1], coordonneesY[1]);
    batch.end();
  }

  public void testBordures() {
    for (int i=0; i<2 ;i ++){  //.length = len 
      if (coordonneesY[i] + hauteursImg[i] >= hauteurFenetre){ //haut
        couleursDVD[i] ++; // x ++ => x +=1 et x -- => x -=1
        directionsEnY[i] = 1;
      }  

      if (coordonneesX[i] + largeursImg[i] >= largeurFenetre){ //droite
        couleursDVD[i] ++;
        directionsEnX[i] = 1;
        directionsEnX[i] = 1;
      }

      if (coordonneesY[i] <= 0){ //bas
        couleursDVD[i] += 1;
        directionsEnY [i] = 0;
      }

      if (coordonneesX[i] <= 0){ //gauche
        couleursDVD[i] += 1;
       directionsEnX [i] = 0;
      }
    }
  }

  public void majcoordonnees() {
    for (int i=0; i<2 ;i ++){
      if (directionsEnY[i] == 0){
        coordonneesY[i] += 10; //monte 
      } else{
        coordonneesY[i] -= 10; //descend 
      }
      if (directionsEnX [i] == 0){
        coordonneesX[i] += 10; //droite
      } else{
        coordonneesX[i] -= 10; //gauche
      }
    }
  }

  public void defCouleurDVD() {
    for (int i=0; i<2; i++){
      if (couleursDVD[i] >= 10){
        couleursDVD[i] = 0;
      }
      else if (couleursDVD[i] == 0){
        imgs[i] = new Texture("dvd.png");
      }
      else if (couleursDVD[i] == 1){
        imgs[i] = new Texture("dvdj.png");
      }
      else if (couleursDVD[i] == 2){
        imgs[i] = new Texture("dvdr.png");
      }
      else if (couleursDVD[i] == 3){
        imgs[i] = new Texture("dvdv.png");
      }
      else if (couleursDVD[i] == 4){
        imgs[i] = new Texture("dvdb.png");
      }
      else if (couleursDVD[i] == 5){
        imgs[i] = new Texture("dvdc.png");
      }
      else if (couleursDVD[i] == 6){
        imgs[i] = new Texture("dvdlv.png");
      }
     else if (couleursDVD[i] == 7){
       imgs[i] = new Texture("dvdg.png");
      }
      else if (couleursDVD[i] == 8){
       imgs[i] = new Texture("dvdvio.png");
      }
     else{
       imgs[i] = new Texture("dvdo.png");
      }
    }
  }

  public void reinitialiserBackground() {
    ScreenUtils.clear(0, 0, 0, 0);
  }

}
