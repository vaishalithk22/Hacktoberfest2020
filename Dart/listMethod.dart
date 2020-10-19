void main() {
  var myList = [1,2,3,4,5,6,7,8,9];
  
  //sublist 
   print(myList.sublist(1,4)); //[2, 3, 4]
  
  
  //reverse List
   print(myList.reversed.toList()); //[9, 8, 7, 6, 5, 4, 3, 2, 1]
  
  
  //List fold
  var res = myList.fold(5, (i, j) => i + j);
  print('res is ${res}'); //res is 50
  
  //List reduce
  var res1 = myList.reduce((i, j) => i + j);
  print('res is ${res1}'); //res is 45
   
  //List as Map
  List<String> sports = ['cricket', 'football', 'tennis', 'baseball'];
  Map<int, String> map = sports.asMap();
  print(map); // {0: cricket, 1: football, 2: tennis, 3: baseball}
  
}
