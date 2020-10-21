#include <stdio.h>
#include <stdlib.h>

typedef struct node {
  int data;
  struct node *next;
} node;
typedef node *list;

void init(list*);
void append(list*, int);
void traverse(list);
int length(list);
void deleteDuplicateNode(list*);
void reverse(list*);
int compareLists(list, list);

int main() {
	list l1, l2;
	int j , n, index, pos, ele;
	init(&l1);
	printf("Enter number of elements in list:");
	scanf("%d", &n);
	for(int i = 0; i < n; i++) {
		printf("Enter number %d: ", i + 1);
		scanf("%d", &j);
		append(&l1, j);
	}
	traverse(l1);
	printf("Operations on Linked List\n");
	printf("1: Delete duplicate elements of a sorted list\n");
	printf("2: Reverse the linked list\n");
	printf("3: Compare two lists\n");
	printf("4: Exit\n");
	do {
		printf("Select an operation to perform on linked list: ");
		scanf("%d", &index);
		switch(index) {
			case 1: deleteDuplicateNode(&l1);
					traverse(l1);
					break;
			case 2: reverse(&l1);
					traverse(l1);
					break;
			case 3: init(&l2);
					printf("Enter number of elements in second list:");
					scanf("%d", &n);
					for(int i = 0; i < n; i++) {
						printf("Enter number %d: ", i + 1);
						scanf("%d", &j);
						append(&l2, j);
					}
					traverse(l1);
					traverse(l2);
					printf("Comparison: %d\n", compareLists(l1, l2));
					break;
			case 4: exit(0);
					break;
			default: printf("Invalid Choice entered");
		}
	} while(index);
	return 0;
}

void init(list * l) {
  * l = NULL;
  return;
}

void append(list * l, int data) {
  node * newnode, * q;
  newnode = (node * ) malloc(sizeof(node));
  if (newnode) {
    newnode -> data = data;
    newnode -> next = NULL;
  } 
  else
    return;
  if ( * l == NULL) {
    * l = newnode;
    return;
  }
  q = * l;
  while (q -> next)
    q = q -> next;
  q -> next = newnode;
  return;
}

int length(list l) {
  int len = 0;
  node * p = l;
  if (p == NULL) {
    len = 0;
    return len;
  }
  while (p) {
    len = len + 1;
    p = p -> next;
  }
  return len;
}

void traverse(list l) {
  node * p = l;
  if (p == NULL) {
    printf("List is empty\n");
    return;
  }
  printf("Linked List: ");
  while (p) {
    printf("%d ", p -> data);
    p = p -> next;
  }
  printf("\n");
  return;
}

void deleteDuplicateNode(list * l) {
  node * p, * q;
  p = * l;
  if (p == NULL)
    return;
  while (p -> next) {
    if (p -> data == p -> next -> data) {
      q = p -> next -> next;
      free(p -> next);
      p -> next = q;
    } 
    else
      p = p -> next;
  }
  return;
}

void reverse(list * l) {
  node * p, * q, * r;
  p = * l;
  q = r = NULL;
  if (p == NULL)
    return;
  while (p) {
    r = p -> next;
    p -> next = q;
    q = p;
    p = r;
  }
  * l = q;
  return;
}

int compareLists(list l1, list l2) {
  node * p, * q;
  int i = 0, cmpr = 0;
  p = l1;
  q = l2;
  if (length(l1) == length(l2)) {
    while (p && q) {
      if (p -> data == q -> data) {
        p = p -> next;
        q = q -> next;
        i = i + 1;
      } 
      else
        break;
    }
    if (i == length(l1)) {
      cmpr = 1;
      return cmpr;
    } 
    else {
      cmpr = -1;
      return cmpr;
    }
  } 
  else {
    cmpr = -1;
    return cmpr;
  }
}
