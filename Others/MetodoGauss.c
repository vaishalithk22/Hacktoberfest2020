#include <stdio.h>
/*
  𝑋1 +   4𝑋2 + 52𝑋3 =  57
27𝑋1 + 110𝑋2 −  3𝑋3 = 134
22𝑋1 +   2𝑋2 + 14𝑋3 =  38
*/

int main()
{
	int i, j, k;
	float  A[3][3] = {1, 4, 52, 27, 110, -3, 22, 2, 14};
	float AE[3][4] = {0,0,0,57, 0,0,0,134, 0,0,0,38};
	float X[3];

	//float  A[3][3] = {2, 1, -3, -1, 3, 2, 3, 1, -3};
	//float AE[3][4] = {0,0,0,-1, 0,0,0,12, 0,0,0,0};
	//A
	printf("MATRIZ A\n");
	for(i = 0; i < 3; i++)
	{
		for(j = 0; j < 3; j++)
			printf("%.0f	",  A[i][j]);
		printf("\n");
	}

	//AE = A
	for(i = 0; i < 3; i++)
	{
		for(j = 0; j < 3; j++)
			AE[i][j] = A[i][j];
	}

	//AE
	printf("\nMATRIZ AE (ESTENDIADA)\n");
	for(i = 0; i < 3; i++)
	{
		for(j = 0; j < 4; j++)
			printf("%.0f	",  AE[i][j]);
		printf("\n");
	}

	//Gauss
	float seguranca = 0;
	for(i = 0; i < 3; i++)
	{
		for(j = i+1; j < 3; j++)
		{
			for(k = 0; k < 4; k++)
			{
				if((AE[j][k] != 0) && (j > i) && (i == k))
				{
					seguranca = AE[j][i];
					//printf("AE[%d][%d]  = %.0f\n", j, k, AE[j][k]);
				}
				AE[j][k] = AE[j][k] - (AE[i][k] * (seguranca / AE[i][i]));
				//printf("AE[%d][%d]  = %.0f\n", j, k, AE[j][k]);
			}
		}
		seguranca = 0;
	}

	printf("\nMATRIZ APOS GAUSS\n");
	for(i = 0; i < 3; i++)
	{
		for(j = 0; j < 4; j++)
			printf("%.0fx%d		",  AE[i][j], i+1);
		printf("\n");
	}

	//Resolucao
	printf("\nSOLUCAO DO SISTEMA\n");
	X[2] = AE[2][3] / AE[2][2];
	X[1] = (AE[1][3] - (AE[1][2] * X[2])) / AE[1][1];
	X[0] = (AE[0][3] - (AE[0][1] * X[1]) - (AE[0][2] * X[2])) / AE[0][0];

	for(i = 0; i < 3; i++){
		printf("X%d = %.0f\n", i+1, X[i]);
	}

	//X[0] = 

	return 0;
}
