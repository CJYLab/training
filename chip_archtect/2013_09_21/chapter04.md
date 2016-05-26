# ��4�� Opteron�̖��߃L���b�V���ƃf�R�[�f�B���O

- 4.1 ���߃L���b�V��: 1�ȏ�̖��߂��i�[����
- 4.2 ��ʓI�Ȗ��߃t�H�[�}�b�g
- 4.3 �v���f�R�[�h�r�b�g
- 4.4 ������v���f�R�[�f�B���O
- 4.5 �����ׂ̕���\��
- 4.6 ���サ������\��
- 4.7 ����Z���N�^
- 4.8 ����^�[�Q�b�g�o�b�t�@
- 4.9 �O���[�o���q�X�g��2���[�h�J�E���^
- 4.10 1���C��������3����̃��[�J��&�O���[�o������\��
- 4.11 ����^�[�Q�b�g�A�h���X�v�Z�A����^�[�Q�b�g�o�b�t�@�̃o�b�N�A�b�v
- 4.12 ���߃L���b�V���q�b�g/�~�X�̌���B���݂̃y�[�W��BTAC
- 4.13 ���߃L���b�V���X�k�[�s���O

![Opteron's Instruction and Decoding Pipeline](Opteron_Instr_Cache.jpg)

## 4.1 ���߃L���b�V��: 1�ȏ�̖��߂��i�[����

���߃L���b�V���ւ̃A�N�Z�X��128�r�b�g���ł���B
1�T�C�N����16�o�C�g���̖��߂��L���b�V���Ƀ��[�h�����B
���߂̃o�C�g��́A76�r�b�g�̕t�����������Ă���B
���̊g���r�b�g�ɂ��A�L���b�V���|�[�g���烍�[�h����閽�߂̑S�̃r�b�g����204�r�b�g�ƂȂ�B
�������܂����B�̓t�����߃L���b�V�����J�o�[���邾���̃r�b�g���������Ă��Ȃ��B
�܂�A1024�̃L���b�V�����C���́A���ꂼ��t���r�b�g�������Ă���B
������1024�G���g���������Ȃ��A����ɑ����̃t�B�[���h�������Ă���A�L���b�V�����C���̈ꕔ�ł̂ݗL���ƂȂ�B

|                        | Instruction only | Total Size |
|------------------------|------------------|------------|
| Instruction Cache size | 64 kByte         | 102 kByte  |
| Cache Line size        | 64 Byte          | 102 Byte   |
| One Read Port          | 128 bit          | 204 bit    |
| One Write Port         | 128 bit          | 204 bit    |

�ǂ��m���Ă���̂́A�e�o�C�g�ɕt������Ă���v���f�R�[�h�r�b�g�ƌĂ΂��3�r�b�g�̃f�[�^�ł���B
�����̃r�b�g�́A���G��x86�ϒ����߂̐擪�ƍŌ���Ƀ}�[�N����A�������̋@�\�I�ȏ���񋟂���B
�c���2�r�b�g�t�B�[���h�̓p���e�B�r�b�g�ł���A1��16�r�b�g�f�[�^���ɕt������A��ʂɕ���Z���N�^�ƌĂ΂��
(16�o�C�g���C���̖��߃R�[�h�ɂ��A2�r�b�g�̃p���e�B�r�b�g��8���t�������)�B

Opteron�̕���Z���N�^�͑���Athlon(32)�Ƃ͈قȂ�A�S�Ă̖��߃L���b�V������1024�L���b�V�����C���S�Ă��J�o�[���邱�Ƃ��ł���B
����Z���N�^�ɂ́A�v���f�R�[�h���Ƃ��ĒT�����邱�Ƃ��ł��Ȃ��A���[�J������\����񂪊܂܂�Ă���B
�������̃R�[�h�͕���Z���N�^���L���ȈӖ������܂łɕ�������s�����B

�L���b�V�����C�����j�����ꂽ�Ƃ��Ă��A����Z���N�^�r�b�g���������ꂽ2���L���b�V���̖��߃f�[�^�ɕۑ�����Ă���̂͂��̂悤�ȗ��R�ł���B
����Z���N�^�͊e�o�C�g�ɗ]����1�r�b�g�Ƃ��ĕt�������B
���x��2�L���b�V���͂��̃r�b�g��ECC(Error Coding and Correction)���̂��߂ɕێ����Ă���B
ECC�̓f�[�^�L���b�V�����C���ł������p���ꂸ�A���߃L���b�V�����C���ł͗��p����Ȃ��B
��҂ł�ECC�͕K�v�Ȃ��̂ŁA�L���b�V�����C�����̂������̃p���e�B�r�b�g���i�[����̂ɂ͏\���ł���B
���߃L���b�V�����C���ɂ����ďՓ˂������̂́A��ɊO��DRAM����������擾�����B

|                  | Ram Size  | Bus Size | Comments                                                        |
|------------------|-----------|----------|-----------------------------------------------------------------|
| Instruction Code | 64 kByte  | 128 bit  | 16 bytes instruction code                                       |
| Parity bits      | 4 kByte   | 8 bit    | One parity bit for each 16 bit                                  |
| Pre-decode       | 26 kByte  | 52 bit   | 3 bits per byte (start, end, function) + 4 bit per 16 byte line |
| Branch Selectors | 8 kByte   | 16 bit   | 2 bits for each 2 bytes of instruction code                     |
| TOTAL            | 102 kByte | 204 bit  |                                                                 |

![Opteron's Instruction Cache](Opteron_Instruction_Cache_Ill.jpg)

## 4.2 ��ʓI�Ȗ��߃t�H�[�}�b�g

64�r�b�g���߂̊ȒP�ȊT�v�ł���B

�A�������v���t�B�b�N�X���A���ۂ̖��߂̑O�ɕt�����邱�Ƃ��ł���B
�ŏ��́A���K�V�[�ȃv���t�B�b�N�X���t�������B
�ł��d�v�ȃ��K�V�[�v���t�B�b�N�X�̓I�y�����h�T�C�Y���I�[�o���C�h����v���t�B�b�N�X(hex 66)�ƁA�A�h���X�T�C�Y�̃I�[�o���C�h�v���t�B�b�N�X(hex 67)�ł���B
�����̃v���t�B�b�N�X�́A�f�B�X�v���[�X�����g�Ƒ��l�t�B�[���h�̒������A1,2,4�o�C�g�̒����ɕύX���邱�Ƃ��ł��邽�߁A�S�̖̂��ߒ������肷��B

REX�v���t�B�b�N�X(hex 4X)�́A64�r�b�g�̐V�����v���t�B�b�N�X�ŁA64�r�b�g�������\�ɂ���B
X�̒l�͔ėp���W�X�^��SSE���W�X�^�̐���8����16�Ɋg������ۂɎg�p����B
x86�́A�f�[�^��A�h���X���w�肷�邽�߂�1���߂�����ő��3�̃��W�X�^���w�肷�邽�߁A�����̃r�b�g�͂��̖ړI�ɗ��p�����B
4�Ԗڂ̃r�b�g�̓I�y�����h�̃T�C�Y���I�[�o���C�h���邽�߂Ɏg�p�����(�f�t�H���g�T�C�Y���A64�r�b�g�Ɋg�������)�B

Escape�v���t�B�b�N�X(hex 0F)��SSE���߂���肷�邽�߂ɗ��p�����B
�I�y�R�[�h�͎��ۂɂ̓v���t�B�b�N�X�̌ォ��n�܂�B
1����2�o�C�g�̃I�v�V���i����MODRM�o�C�g��SIB�o�C�g��t�����邱�Ƃ��ł���B
�I�v�V�����̃f�B�X�v���[�X�����g�Ƒ��l�t�B�[���h�́A�A�h���X����уf�[�^�̌v�Z�̂��߂ɒ萔���i�[���邱�Ƃ��ł��A1,2,4�o�C�g�̂����ǂꂩ����邱�Ƃ��ł���B
���ߑS�̂̒����́A15�o�C�g�܂łɐ��������B

![Opteron's Instruction Format](Opteron_instruction_format_780x200.jpg)

## 4.3 �v���f�R�[�h�r�b�g

���߃L���b�V�����̊e�o�C�g�ɂ́A�v���f�R�[�_�ɂ���Đ������ꂽ���ꂼ��3�r�b�g�̃v���f�R�[�h�r�b�g���t�����Ă���B
�����̃r�b�g�́A�ϒ����߂̃f�R�[�h������������B
�e���߃o�C�g�ɂ́A�ϒ��r�b�g���߂̐擪�������X�^�[�g�r�b�g�ƁA�Ō�������X�g�b�v�r�b�g���ǉ�����Ă���B
1�{�Ɩ��߂ɂ́A�ǂ���̃r�b�g���L��������Ă���B
3�Ԗڂ̃r�b�g�A�@�\�r�b�g�ɂ��A�ʂ̏�񂪊i�[����Ă���B
�܂��f�R�[�_�́A�ϒ����߂ɂ�����Ō�̃o�C�g�Ɋi�[����Ă���@�\�r�b�g���Q�Ƃ���B
�����@�\�r�b�g��0�Ȃ�΁A���̖��߂́A�����钼�ڃp�X���߂ł���A�@�\���j�b�g�͒��ڏ��������B
�����łȂ���΁A�܂�ϒ����߂ɂ�����Ō�̃o�C�g�̋@�\�r�b�g��1�ł���Ȃ�΁A������x�N�g���p�X���߂ł���B
�}�C�N���R�[�h�v���O�����ɂ�鏈�����K�v�ȁA��蕡�G�Ȗ��߂ł��邱�Ƃ������B


�v���f�R�[�h�r�b�g�̒�`

| START bit  | ���߂̍ŏ��̃o�C�g�ł��邱�Ƃ�����                                                                                                                                                                                                                                                                                                                                 |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| END bit    | ���߂̍Ō�̃o�C�g�ł��邱�Ƃ�����                                                                                                                                                                                                                                                                                                                                 |
| �@�\�r�b�g | rule 1:,Direct Path instruction, if 0 on the last byte,Vector Path instruction if 1 on the last byte,rule 2:,1 indicates Prefix byte of Direct Path,(except last byte),0 indicates Prefix byte of Vector Path,(except last byte),rule 3:,For vector-path instructions only:,if the function bit of the MODRM byte is set then,the instruction contains a SIB byte. |

2�ԖڂɁA�@�\�r�b�g�̓v���t�B�b�N�X�o�C�g�����ʂ���B
�@�\�r�b�g��1�ł���ꍇ�A�_�C���N�g�p�X���߂̃v���t�B�b�N�X�o�C�g�ł���A0�ł���Ȃ�΁A�x�N�g���p�X���߂̃v���t�B�b�N�X�o�C�g�ł���B
�Ō�ɁA�x�N�g���p�X���߂ł���ꍇ�Ɍ���ABODRM�o�C�g�@�\�r�b�g���Z�b�g����Ă���Ȃ�΁ASIB�o�C�g�����߂Ɋ܂܂�Ă��邱�Ƃ������B
