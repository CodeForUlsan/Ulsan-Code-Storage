#include "Headers\HeaderCollect.h"

/*
�������� �α�
!!!�����Ŀ��� �ݵ�� �α׸� �������ֽʽÿ�!!!
�α� ��Ģ - �տ��� ������ ���ڰ� ���ϴ�. ���ڵڿ� �ٴ� Revision�� �ش��� ù��° �ǿø��� ��� ���� 1�� �ι�°�� ��쿣 ���� 2�� �ٿ��ֽø� �˴ϴ�.
ex)2018�� 12�� 21�� ù��° ������ - 2018.12.21.Revision1, 2018�� 12�� 21�� �ι�° ������ - 2018.12.21.Revision2
2018.12.21.Revision1
*/

DWORD MciGetPlayPosition(DWORD *TotalTime, UINT *MciDeviceID)
{
	MCI_SET_PARMS MciSetParms;
	MCI_STATUS_PARMS MciStatusParms;
//	DWORD *TotalTime;
	DWORD CurrentTime;

	MciSetParms.dwTimeFormat = MCI_FORMAT_MILLISECONDS;
	mciSendCommand(*MciDeviceID, MCI_SET, MCI_SET_TIME_FORMAT, (DWORD)&MciSetParms);

	MciStatusParms.dwItem = MCI_STATUS_LENGTH;
	mciSendCommand(*MciDeviceID, MCI_STATUS, MCI_STATUS_ITEM, (DWORD)(LPVOID)&MciStatusParms);
	*TotalTime = MciStatusParms.dwReturn;

	MciStatusParms.dwItem = MCI_STATUS_POSITION;
	mciSendCommand(*MciDeviceID, MCI_STATUS, MCI_STATUS_ITEM, (DWORD)(LPVOID)&MciStatusParms);
	CurrentTime = MciStatusParms.dwReturn;

	return CurrentTime;
}