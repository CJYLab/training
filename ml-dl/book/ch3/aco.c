/****************************************/
/*                aco.c                 */
/*  �a�R���j�[�œK���@(aco)�v���O����   */
/*   aco�ɂ��œK�l���w�K���܂�        */
/*�g����                                */
/*\Users\odaka\dl\ch3>aco               */
/****************************************/


/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/*�w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>

/*   �L���萔�̒�`                 */
#define NOA 10 /*�a�̌̐�*/
#define ILIMIT 50 /*�J��Ԃ��̉�*/
#define Q 3 /*�t�F�������X�V�̒萔*/
#define RHO 0.8 /*�����̒萔*/
#define STEP 10 /*���̂�̃X�e�b�v��*/
#define EPSILON 0.15 /*�s���I���̃����_����������*/
#define SEED 32768 /*�����̃V�[�h*/


/*   �֐��̃v���g�^�C�v�̐錾      */
void printp(double pheromone[2][STEP]) ;/*�\��*/
void printmstep(int mstep[NOA][STEP]) ;
                             /*�a�̋����̕\��*/
void walk(int cost[2][STEP]
          ,double pheromone[2][STEP]
          ,int mstep[NOA][STEP] ) ;/*�a���������*/
void update(int cost[2][STEP]
         ,double pheromone[2][STEP]
        ,int mstep[NOA][STEP] ) ;/*�t�F�������̍X�V*/
double rand1() ;/*0�`1�̎�����Ԃ������֐�*/
int rand01() ;/*0����1��Ԃ������֐�*/


/**********************/
/*     main()�֐�     */
/**********************/
int main()
{
 int cost[2][STEP]={/*�e�X�e�b�v�̃R�X�g(�����j*/
	 {1,1,1,1,1,1,1,1,1,1},
	 {5,5,5,5,5,5,5,5,5,5}};
 double pheromone[2][STEP]={0} ;/*�e�X�e�b�v�̃t�F��������*/
 int mstep[NOA][STEP] ;/*�a���������ߒ�*/
 int i;/*�J��Ԃ��񐔂̐���*/
 
 /*�����̏�����*/
 srand(SEED) ;

 /*�œK���̖{��*/
 for(i=0;i<ILIMIT;++i){
  /*�t�F�������̏�ԏo��*/
  printf("%d:\n",i) ;
  printp(pheromone) ;
  /*�a���������*/
  walk(cost,pheromone,mstep) ;
  /*�t�F�������̍X�V*/
  update(cost,pheromone,mstep) ;
 }
 /*�t�F�������̏�ԏo��*/
 printf("%d:\n",i) ;
 printp(pheromone) ;
 
 return 0 ;
}

/**************************/
/*    update()�֐�        */
/*    �t�F�������̍X�V    */
/**************************/
void update(int cost[2][STEP]
        ,double pheromone[2][STEP]
        ,int mstep[NOA][STEP] )
{
 int m ;/*�a�̌̔ԍ�*/
 int lm ;/*�a�̕���������*/
 int i,j ;
 double sum_lm=0 ;/*�a�̕��������v����*/
 
 /*�t�F�������̏���*/
 for(i=0;i<2;++i)
  for(j=0;j<STEP;++j)
   pheromone[i][j]*=RHO ;

 /*�a�ɂ���h��*/
 for(m=0;m<NOA;++m){
  /*��m�̈ړ�����lm�̌v�Z*/
  lm=0 ;
  for(i=0;i<STEP;++i)
   lm+=cost[mstep[m][i]][i] ;

  /*�t�F�������̏�h��*/
  for(i=0;i<STEP;++i)
   pheromone[mstep[m][i]][i]+=Q*(1.0/lm) ;
  sum_lm+=lm ;
 }
 /*�a�̕��������ϋ������o��*/
 printf("%lf\n",sum_lm/NOA) ;
}

/**************************/
/*    walk()�֐�          */
/*    �a���������        */
/**************************/
void walk(int cost[2][STEP]
,double pheromone[2][STEP],int mstep[NOA][STEP])
{
 int m ;/*�a�̌̔ԍ�*/
 int s ;/*�a�̌��݃X�e�b�v�ʒu*/

 for(m=0;m<NOA;++m){
  for(s=0;s<STEP;++s){
   /*��-greedy�@�ɂ��s���I��*/
   if((rand1()<EPSILON)
    ||(abs(pheromone[0][s]-pheromone[1][s])<1e-9))
   {/*�����_���ɍs��*/
    mstep[m][s]=rand01() ;
   }
   else{/*�t�F�������Z�x�ɂ��I��*/
    if(pheromone[0][s]>pheromone[1][s]) 
      mstep[m][s]=0 ;
    else
      mstep[m][s]=1 ;
   }
 }
 }
 /*�a�̋����̏o��*/
 printmstep(mstep) ;
}

/**************************/
/*  printmstep()�֐�      */
/*   �a�̋����̕\��       */
/**************************/
void printmstep(int mstep[NOA][STEP])
{
 int i,j ;

 printf("*mstep\n") ;
 for(i=0;i<NOA;++i){
  for(j=0;j<STEP;++j)
   printf("%d ",mstep[i][j]) ;
  printf("\n") ;
 }
}


/**************************/
/*    printp()�֐�        */
/*   �t�F�������̕\��     */
/**************************/
void printp(double pheromone[2][STEP]) 
{
 int i,j ;

 for(i=0;i<2;++i){
  for(j=0;j<STEP;++j)
   printf("%4.2lf ",pheromone[i][j]) ;
  printf("\n") ;
 }
}

/**************************/
/*    rand1()�֐�         */
/*0�`1�̎�����Ԃ������֐�*/
/**************************/
double rand1()
{
 /*�����̌v�Z*/
 return (double)rand()/RAND_MAX ;

}

/****************************/
/*     rand01()�֐�         */
/*�@   0����1��Ԃ������֐� */
/****************************/
int rand01()
{
 int rnd ;
 
 /*�����̍ő�l������*/
 while((rnd=rand())==RAND_MAX) ;
 /*�����̌v�Z*/ 
 return (int)((double)rnd/RAND_MAX*2) ;

}
