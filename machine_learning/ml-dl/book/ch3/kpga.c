/*****************************************************/
/*                  kpga.c�@�@                       */
/*�@�i�b�v�T�b�N���̂f�`�ɂ�鋁���v���O����       */
/*�f�`�ɂ���āA�i�b�v�T�b�N���̍ŗǉ���T�����܂� */
/* �g�����@                                          */
/*\Users\odaka\dl\ch3>kpga < data.txt                */
/*****************************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/* �w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

/*�L���萔�̒�`*/
#define MAXVALUE 100 /*�d���Ɖ��l�̍ő�l*/
#define N 30 /*�ו��̌�*/
#define WEIGHTLIMIT (N*MAXVALUE/4) /*�d�ʐ���*/
#define POOLSIZE 30 /*�v�[���T�C�Y*/
#define LASTG 50    /*�ł��؂萢��*/
#define MRATE 0.01  /*�ˑR�ψق̊m��*/
#define SEED 32767    /*�����̃V�[�h*/
#define YES 1   /*yes�ɑΉ����鐮���l*/
#define NO 0    /*no�ɑΉ����鐮���l*/

/*�֐��̃v���g�^�C�v�̐錾*/
void initparcel();/*�ו��̏�����*/
int evalfit(int gene[]) ; /*�K���x�̌v�Z*/
void mating(int pool[POOLSIZE][N]
            ,int ngpool[POOLSIZE*2][N]) ; /*����*/
void mutation(int ngpool[POOLSIZE*2][N]) ; /*�ˑR�ψ�*/
void printp(int pool[POOLSIZE][N]) ; /*���ʏo��*/
void initpool(int pool[POOLSIZE][N]) ;
                         /*�����W�c�̐���*/
int rndn() ; /*n�����̗����̐���   */
int notval(int v) ;/*�^���l�̔��]*/
int selectp(int roulette[POOLSIZE],int totalfitness) ;
                    /*�e�̑I��*/
void crossing(int m[],int p[],int c1[],int c2[]) ;
                /* ����̂Q���F�̂̌��� */
void selectng(int ngpool[POOLSIZE*2][N]
              ,int pool[POOLSIZE][N]) ;/*������̑I��*/

/*���ϐ��i�ו��f�[�^)*/
 int parcel[N][2] ;/*�ו�*/

/*******************/
/*    main()�֐�   */
/*******************/
int main(int argc,char *argv[])
{
 int pool[POOLSIZE][N] ; /*���F�̃v�[��*/
 int ngpool[POOLSIZE*2][N] ; /*��������F�̃v�[��*/
 int generation;/* ���݂̐��㐔 */
 
 /*�����̏�����*/
 srand(SEED) ;

 /*�ו��̏�����*/
 initparcel() ;
 
 /*�����W�c�̐���*/
 initpool(pool) ;
 
 /*�ł��؂萢��܂ŌJ��Ԃ�*/
 for(generation=0;generation<LASTG;++generation){
  printf("%d����\n",generation) ;
  mating(pool,ngpool) ;/*����*/
  mutation(ngpool) ;/*�ˑR�ψ�*/
  selectng(ngpool,pool) ;/*������̑I��*/
  printp(pool) ;/*���ʏo��*/
 }

 return 0 ;
}

/****************************/
/*      initparcel()�֐�    */
/*�@    �ו��̏�����   �@   */
/****************************/
void initparcel()
{
 int i=0 ;
 while((i<N) && 
  (scanf("%d %d",&parcel[i][0],&parcel[i][1])
                 !=EOF)){
  ++i ;
 }
}

/************************/
/*   selectng()�֐�     */
/*   ������̑I��       */
/************************/
void selectng(int ngpool[POOLSIZE*2][N]
              ,int pool[POOLSIZE][N]) 
{
 int i,j,c ;/* �J��Ԃ��̐���ϐ� */
 int totalfitness=0 ;/*�K���x�̍��v�l*/
 int roulette[POOLSIZE*2] ;/*�K���x���i�[*/
 int ball ;/* �ʁi�I���ʒu�̐��l�j*/
 int acc=0 ;/*�K���x�̐ώZ�l*/
 
 /*�I�����J��Ԃ�*/
 for(i=0;i<POOLSIZE;++i){
  /* ���[���b�g�̍쐬 */
  totalfitness=0 ;
  for(c=0;c<POOLSIZE*2;++c){
   roulette[c]=evalfit(ngpool[c]) ;
   /* �K���x�̍��v�l���v�Z*/
   totalfitness+=roulette[c] ;
  }
  /*���F�̂���I��*/
  ball=rndn(totalfitness) ;
  acc=0 ;
  for(c=0;c<POOLSIZE*2;++c){
   acc+=roulette[c] ;/*�K���x��ώZ*/
   if(acc>ball) break ;/*�Ή������`�q*/
  }

  /*���F�̂̃R�s�[*/
  for(j=0;j<N;++j){
   pool[i][j]=ngpool[c][j] ;
  }
 }
}

/************************/
/*   selectp()�֐�      */
/*    �e�̑I��          */
/************************/
int selectp(int roulette[POOLSIZE],int totalfitness)
{
 int i ;/* �J��Ԃ��̐���ϐ� */
 int ball ;/* �ʁi�I���ʒu�̐��l�j*/
 int acc=0 ;/*�K���x�̐ώZ�l*/

 ball=rndn(totalfitness) ;
 for(i=0;i<POOLSIZE;++i){
  acc+=roulette[i] ;/*�K���x��ώZ*/
  if(acc>ball) break ;/*�Ή������`�q*/
 }
 return i ;
}


/************************/
/*   mating()�֐�       */
/*        ����          */
/************************/
void mating(int pool[POOLSIZE][N]
           ,int ngpool[POOLSIZE*2][N])
{
 int i ;/* �J��Ԃ��̐���ϐ� */
 int totalfitness=0 ;/*�K���x�̍��v�l*/
 int roulette[POOLSIZE] ;/*�K���x���i�[*/
 int mama,papa ;/*�e�̈�`�q�̔ԍ�*/

 /* ���[���b�g�̍쐬 */
 for(i=0;i<POOLSIZE;++i){
  roulette[i]=evalfit(pool[i]) ;
  /* �K���x�̍��v�l���v�Z*/
  totalfitness+=roulette[i] ;
 }

 /*�I���ƌ������J��Ԃ�*/
 for(i=0;i<POOLSIZE;++i){
  do{/*�e�̑I��*/
   mama=selectp(roulette,totalfitness) ;
   papa=selectp(roulette,totalfitness) ;
  }while(mama==papa) ;/*�d���̍폜*/

  /*����̂Q��`�q�̌���*/
  crossing(pool[mama],pool[papa]
            ,ngpool[i*2],ngpool[i*2+1])  ;  
 }
}


/************************/
/*  crossing()�֐�      */
/* ����̂Q���F�̂̌��� */
/************************/
void crossing(int m[],int p[],int c1[],int c2[])
{
 int j ;/* �J��Ԃ��̐���ϐ� */
 int cp ;/*��������_*/

 /*�����_�̌���*/
 cp =rndn(N) ;

 /*�O�������̃R�s�[*/
 for(j=0;j<cp;++j){
  c1[j]=m[j] ;
  c2[j]=p[j] ;
 }
 /*�㔼�����̃R�s�[*/
 for(;j<N;++j){
  c2[j]=m[j] ;
  c1[j]=p[j] ;
 }
}

/************************/
/*   evalfit()�֐�      */
/*   �K���x�̌v�Z       */
/************************/
int evalfit(int g[])
{
 int pos ;/*��`�q���̎w��*/
 int value=0 ;/*�]���l*/
 int weight=0 ;/*�d��*/

 /*�e��`�q���𒲂ׂďd�ʂƕ]���l���v�Z*/
 for(pos=0;pos<N;++pos){
  weight+=parcel[pos][0]*g[pos] ;
  value+=parcel[pos][1]*g[pos] ;
 }
 /*�v����`�q�̏���*/
 if(weight>=WEIGHTLIMIT) value=0 ;
 return value;
 
}

/***********************/
/*   printp()�֐�      */
/*   ���ʏo��          */
/***********************/
void printp(int pool[POOLSIZE][N])
{
 int i,j ;/* �J��Ԃ��̐���ϐ� */
 int fitness ;/* �K���x */
 double totalfitness=0 ;/* �K���x�̍��v�l */
 int elite,bestfit=0 ;/*�G���[�g��`�q�̏����p�ϐ�*/

 for(i=0;i<POOLSIZE;++i){
  for(j=0;j<N;++j)
   printf("%1d",pool[i][j]) ;
  fitness=evalfit(pool[i]) ;
  printf("\t%d\n",fitness) ;
  if(fitness>bestfit){/*�G���[�g��*/
   bestfit=fitness ;
   elite=i ;
  }
  totalfitness+=fitness ;
 }
 /*�G���[�g���̓K���x���o��*/
 printf("%d\t%d \t",elite,bestfit) ;
 /*���ς̓K���x���o��*/
 printf("%lf\n",totalfitness/POOLSIZE) ;
}


/***********************/
/*   initpool()�֐�    */
/*   �����W�c�̐���    */
/***********************/
void initpool(int pool[POOLSIZE][N])
{
 int i,j ;/* �J��Ԃ��̐���ϐ� */

 for(i=0;i<POOLSIZE;++i)
  for(j=0;j<N;++j)
   pool[i][j]=rndn(2) ;
}


/************************/
/*     rndn()�֐�       */
/*    n�����̗����̐��� */
/************************/
int rndn(int l)
{
 int rndno ;/*������������*/

 while((rndno=((double)rand()/RAND_MAX)*l)==l) ;

 return rndno;
}

/***********************/
/*   mutation()�֐�    */
/*   �ˑR�ψ�          */
/***********************/
void mutation(int ngpool[POOLSIZE*2][N])
{
 int i,j ;/* �J��Ԃ��̐���ϐ� */

 for(i=0;i<POOLSIZE*2;++i)
  for(j=0;j<N;++j)
   if((double)rndn(100)/100.0<=MRATE)
    /*���]�̓ˑR�ψ�*/
    ngpool[i][j]=notval(ngpool[i][j]) ;

}

/************************/
/*   notval()�֐�       */
/*   �^���l�̔��]       */
/************************/
int notval(int v)
{
 if(v==YES) return NO ;
 else return YES ;
}

