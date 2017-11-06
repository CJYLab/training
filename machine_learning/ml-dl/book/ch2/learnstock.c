/********************************************/
/*         learnstock.c                     */
/*  �P���ȋA�[�I�w�K�̗��v���O����        */
/*            �p�^�[���w�K��                */
/*100�̊w�K�f�[�^��ǂݍ���ŁA           */
/*�K������P�O���̂Q�i���p�^�[���𓚂��܂�  */
/*�g����                                    */
/*:\Users\odaka\dl\ch2>learnstock<ldata.txt */
/********************************************/

/*Visual Studio�Ƃ̌݊����m�� */
#define _CRT_SECURE_NO_WARNINGS

/*�w�b�_�t�@�C���̃C���N���[�h*/
#include <stdio.h>
#include <stdlib.h>

/* �L���萔�̒�`             */
#define OK 1 
#define NG 0
#define SETSIZE 100 /*�w�K�f�[�^�Z�b�g�̑傫��*/
#define CNO 10 /*�w�K�f�[�^�̌����i10�Е��j*/
#define GENMAX  10000 /*����␶����*/
#define SEED 32767 /*�����̃V�[�h*/

/* �֐��̃v���g�^�C�v�̐錾   */
void readdata(int data[SETSIZE][CNO],int teacher[SETSIZE]) ;
           /*�w�K�f�[�^�Z�b�g�̓ǂݍ���*/
int rand012() ;/*0�C1����2��Ԃ������֐�*/
int calcscore(int data[SETSIZE][CNO],int teacher[SETSIZE],
              int answer[CNO]) ;
           /*�����p�^�[���̃X�R�A�i0�`SETSIZE�_�j�̌v�Z*/


/****************/
/*  main()�֐�  */
/****************/
int main()
{
 int i, j;
 int score = 0;/*�X�R�A�i0�`SETSIZE�_�j*/
 int answer[CNO];/*�����*/
 int data[SETSIZE][CNO];/*�w�K�f�[�^�Z�b�g*/
 int teacher[SETSIZE];/*���t�f�[�^*/
 int bestscore = 0;/*�X�R�A�̍ŗǒl*/
 int bestanswer[CNO];/*�T���r���ł̍ŗǉ�*/

 srand(SEED);/*�����̏�����*/

 /*�w�K�f�[�^�Z�b�g�̓ǂݍ���*/
 readdata(data,teacher) ;

 /*����␶���ƌ���*/
 for (i = 0; i<GENMAX; ++i) {
  /*����␶��*/
  for (j = 0; j<CNO; ++j) {
   answer[j] = rand012();
  }

  /*����*/
  score=calcscore(data,teacher,answer) ;

  /*�ŗǃX�R�A�̍X�V*/
  if (score>bestscore) {/*����܂ł̍ŗǒl�Ȃ�X�V*/
   for (j = 0; j<CNO; ++j)
    bestanswer[j] = answer[j];
   bestscore = score;
   for (j = 0; j<CNO; ++j)
    printf("%1d ", bestanswer[j]);
   printf(":score=%d\n", bestscore);
  }
 }
 /*�ŗǉ��̏o��*/
 printf("\n�ŗǉ�\n");
 for (j = 0; j<CNO; ++j)
  printf("%1d ", bestanswer[j]);
 printf(":score=%d\n", bestscore);

 return 0;
}

/**********************************************/
/*            calcscore()�֐�                 */
/*�����p�^�[���̃X�R�A�i0�`SETSIZE�_�j�̌v�Z*/
/**********************************************/
int calcscore(int data[SETSIZE][CNO],int teacher[SETSIZE],
              int answer[CNO])
{
 int score = 0;/*�X�R�A�i0�`SETSIZE�_�j*/
 int point  ;/*��v��������(0�`CNO)  */
 int i,j ;
 
for (i = 0; i<SETSIZE; ++i) {
  /*��v�x�v�Z*/
  point = 0;
  for (j = 0; j<CNO; ++j) {
   if (answer[j] == 2) ++point;/*���C���h�J�[�h*/
   else if (answer[j] == data[i][j]) ++point;/*��v*/
  }

  if ((point == CNO) && (teacher[i] == 1)) {
   ++score;
  }
  else if ((point != CNO) && (teacher[i] == 0)) {
   ++score;
  }
 }
 return score ;
}


/****************************/
/*     readdata()�֐�       */
/*�w�K�f�[�^�Z�b�g�̓ǂݍ���*/
/****************************/
void readdata(int data[SETSIZE][CNO],int teacher[SETSIZE])
{
 int i,j ;
 
 for (i = 0; i<SETSIZE; ++i) {
  for (j = 0; j<CNO; ++j) {
   scanf("%d", &data[i][j]);
  }
  scanf("%d", &teacher[i]);
 }

}


/****************************/
/*     rand012()�֐�        */
/*�@0�C1����2��Ԃ������֐� */
/****************************/
int rand012()
{
 int rnd ;
 
 /*�����̍ő�l������*/
 while((rnd=rand())==RAND_MAX) ;
 /*�����̌v�Z*/ 
 return (double)rnd/RAND_MAX*3 ;

}

