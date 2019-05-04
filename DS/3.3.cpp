#include <iostream>

using namespace std;
int main(int argc, char *argv[]) {
	
	for(int i = 1; i <= 1000; i ++){
		int n = i;
		int times = 0;
		for(int j = 1;j < i; j ++){
			if(i%j==0){
				n-=j;

			}
		}
		if(n==0) {
			cout << i << ' ';
			times++;
		}
				
	}
}