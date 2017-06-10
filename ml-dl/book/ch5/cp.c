/*********************************************************/
/*                   cp.c                                */
/*�@��ݍ��݂ƃv�[�����O�̏���                           */
/*�@2�����f�[�^��ǂݎ��A��ݍ��݂ƃv�[�����O���{���܂�*/
/* �g�����@                                              */
/*  \Users\odaka\dl\ch5>cp < data1.txt                   */
/*********************************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/* �w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


/*�L���萔�̒�`*/
#define INPUTSIZE 11  /*���͐�*/ 
#define FILTERSIZE 3 /*�t�B���^�̑傫��*/
#define POOLSIZE 3 /*�v�[�����O�T�C�Y*/
#define POOLOUTSIZE 3/*�v�[�����O�̏o�̓T�C�Y*/
/*�֐��̃v���g�^�C�v�̐錾*/
void conv(double filter[][FILTERSIZE]
   ,double e[][INPUTSIZE]
   ,double convout[][INPUTSIZE]) ; /*��ݍ��݂̌v�Z*/
double calcconv(double filter[][FILTERSIZE]
               ,double e[][INPUTSIZE],int i,int j) ;
                               /*  �t�B���^�̓K�p  */
void convres(double convout[][INPUTSIZE]) ;
              /*��ݍ��݂̌��ʏo��*/
void pool(double convout[][INPUTSIZE]
         ,double poolout[][POOLOUTSIZE]) ; 
             /*�v�[�����O�̌v�Z*/           
double maxpooling(double convout[][INPUTSIZE]
                 ,int i,int j) ;/* �ő�l�v�[�����O */
void poolres(double poolout[][POOLOUTSIZE]) ;/*���ʏo��*/
void getdata(double e[][INPUTSIZE]) ;/*�f�[�^�ǂݍ���*/ 
         
/*******************/ 
/*    main()�֐�   */ 
/*******************/ 
int main()
{
 double filter[FILTERSIZE][FILTERSIZE]
//      ={{0,0,0},{1,1,1},{0,0,0}} ;/*���t�B���^*/
        ={{0,1,0},{0,1,0},{0,1,0}} ;/*�c�t�B���^*/
 double e[INPUTSIZE][INPUTSIZE] ;/*���̓f�[�^*/
 double convout[INPUTSIZE][INPUTSIZE]={0} ;/*��ݍ��ݏo��*/
 double poolout[POOLOUTSIZE][POOLOUTSIZE] ;/*�o�̓f�[�^*/
 int i,j ;/*�J��Ԃ��̐���*/
 
 /*���̓f�[�^�̓ǂݍ���*/
 getdata(e) ;
 
 /*��ݍ��݂̌v�Z*/
 conv(filter,e,convout) ;
 convres(convout) ;
 
 /*�v�[�����O�̌v�Z*/
 pool(convout,poolout) ;
 /*���ʂ̏o��*/
 poolres(poolout) ;
 
 return 0 ;
}

/**********************/
/*  poolres()�֐�     */
/* �@���ʏo��         */
/**********************/
void poolres(double poolout[][POOLOUTSIZE]) 
{
 int i,j ;/*�J��Ԃ��̐���*/
 
 for(i=0;i<POOLOUTSIZE;++i){
  for(j=0;j<POOLOUTSIZE;++j){
   printf("%.3lf ",poolout[i][j]) ;
  }
  printf("\n") ;
 }
 printf("\n") ;	
} 
 
/**********************/
/*  pool()�֐�        */
/* �v�[�����O�̌v�Z   */
/**********************/
void pool(double convout[][INPUTSIZE]
         ,double poolout[][POOLOUTSIZE]) 
{
 int i,j ;/*�J��Ԃ��̐���*/

 for(i=0;i<POOLOUTSIZE;++i)
  for(j=0;j<POOLOUTSIZE;++j)
   poolout[i][j]=maxpooling(convout,i,j) ;
}
 
/**********************/
/* maxpooling()�֐�   */
/* �ő�l�v�[�����O   */
/**********************/
double maxpooling(double convout[][INPUTSIZE]
                 ,int i,int j)
{
 int m,n ;/*�J��Ԃ��̐���p*/
 double max ;/*�ő�l*/
 int halfpool=POOLSIZE/2 ;/*�v�[�����O�̃T�C�Y��1/2*/
 
 max
 =convout[i*POOLOUTSIZE+1+halfpool][j*POOLOUTSIZE+1+halfpool];
 for(m=POOLOUTSIZE*i+1;m<=POOLOUTSIZE*i+1+(POOLSIZE-halfpool);++m)
  for(n=POOLOUTSIZE*j+1;n<=POOLOUTSIZE*j+1+(POOLSIZE-halfpool);++n)
   if(max<convout[m][n]) max=convout[m][n] ;

 return max ;
}


/**********************/
/*  convres()�֐�     */
/* ��ݍ��݂̌��ʏo�� */
/**********************/
void convres(double convout[][INPUTSIZE]) 
{
 int i,j ;/*�J��Ԃ��̐���*/
 
 for(i=1;i<INPUTSIZE-1;++i){
  for(j=1;j<INPUTSIZE-1;++j){
   printf("%.3lf ",convout[i][j]) ;
  }
  printf("\n") ;
 }
 printf("\n") ;	
} 
              
/**********************/
/*  getdata()�֐�     */
/*���̓f�[�^�̓ǂݍ���*/
/**********************/
void getdata(double e[][INPUTSIZE])
{
 int i=0,j=0 ;/*�J��Ԃ��̐���p*/

 /*�f�[�^�̓���*/
 while(scanf("%lf",&e[i][j])!=EOF){
  ++ j ;
  if(j>=INPUTSIZE){/*���̃f�[�^*/
   j=0 ;
   ++i ;
   if(i>=INPUTSIZE) break ;/*���͏I��*/
  }
 }
}

/**********************/
/*  conv()�֐�        */
/*  ��ݍ��݂̌v�Z    */
/**********************/
void conv(double filter[][FILTERSIZE]
         ,double e[][INPUTSIZE],double convout[][INPUTSIZE])
{
 int i=0,j=0 ;/*�J��Ԃ��̐���p*/
 int startpoint=FILTERSIZE/2 ;/*��ݍ��ݔ͈͂̉���*/

 for(i=startpoint;i<INPUTSIZE-startpoint;++i)
  for(j=startpoint;j<INPUTSIZE-startpoint;++j)
   convout[i][j]=calcconv(filter,e,i,j) ;
}

/**********************/
/*  calcconv()�֐�    */
/*  �t�B���^�̓K�p    */
/**********************/
double calcconv(double filter[][FILTERSIZE]
             ,double e[][INPUTSIZE],int i,int j)
{
 int m,n ;/*�J��Ԃ��̐���p*/
 double sum=0 ;/*�a�̒l*/
 
 for(m=0;m<FILTERSIZE;++m)
  for(n=0;n<FILTERSIZE;++n)
   sum+=e[i-FILTERSIZE/2+m][j-FILTERSIZE/2+n]*filter[m][n];
   
 return sum ;
}

