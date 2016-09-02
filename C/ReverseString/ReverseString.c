#include <stdio.h>
#include <string.h>
char* reverseString(char* s)
{
    int i,j;
    char c;
    for(i = 0, j = strlen(s) - 1; i < j; i++, j--){
	c = s[i];
	s[i] = s[j];
	s[j] = c;
    } 
    return s;
}

int main()
{
    char s[] = "hello";
    char* str = reverseString(s);
    printf("%s\n", str);
}
