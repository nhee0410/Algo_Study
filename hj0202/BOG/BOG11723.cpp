#include <iostream>
#include <cstring>
using namespace std;

bool set[21];
char command[9];

int main()
{
	int countCommand;
	scanf("%d", &countCommand);

	for (int i = 0; i < countCommand; i++)
	{
		scanf("%s", command);

		if (strcmp(command, "all") == 0)
		{
			for (int j = 1; j <= 20; j++)
				set[j] = true;
		}
		else if (strcmp(command, "empty") == 0)
		{
			for (int j = 1; j <= 20; j++)
				set[j] = false;
		}
		else
		{
			int x;
			scanf("%d", &x);

			if (strcmp(command, "add") == 0)
				set[x] = true;
			else if (strcmp(command, "remove") == 0)
				set[x] = false;
			else if (strcmp(command, "check") == 0)
				printf("%d\n", set[x]);
			else if (strcmp(command, "toggle") == 0)
				set[x] = !set[x];
		}
	}
}