#include <iostream>
#include <stdlib.h>

using namespace std;
template <class Record>
void ImprovedInsertSort(Record arr[], int n){
    Record tempRecord;
    for(int i = 1; i < n; i++){
        tempRecord = arr[i];
        int index = i - 1;
        while(index >= 0 && tempRecord < arr[index]){
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1] = tempRecord;
    }
    for(int m = 0; m < 10; m++) cout << arr[m];
}
using namespace std;
int main()
{
    int arr[10];
    cout << "the array is : (10)" << endl;
    for(int i = 0; i < 10; i++){
        cin >> arr[i];
    }
    ImprovedInsertSort(arr, 10);
    return 0;
}
