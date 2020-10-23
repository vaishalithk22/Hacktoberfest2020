#include <stdio.h>
#include <stdlib.h>

/*
Develop a program for forming a stack containing positive integers
numbers, and its transformation by removing all even numbers from it.
*/
typedef struct Node_tag {
    int value;
    struct Node_tag *next;
} Node;


void push(Node **head, int value) {
    Node *tmp = malloc(sizeof(Node));
    tmp->next = *head;
    tmp->value = value;
    *head = tmp;
}

int pop(Node **head) {
    Node *out;
    int value;
    out = *head;
    *head = (*head)->next;
    value = out->value;
    free(out);
    return value;
}

void main() {
    int i;

    // Initial main stack
    Node *head_main_stack = NULL;
    for (i = 1; i < 10; i++) {
        push(&head_main_stack, i);
    }

    // Initial and change main stack
    int number;
    Node *head_temp_stack = NULL;
    puts("Main stack without change:");
    while (head_main_stack) {
        number = pop(&head_main_stack);
        printf("%d\n", number);
        if (number % 2) {
            push(&head_temp_stack, number);
        }
    }
    while (head_temp_stack) {
        push(&head_main_stack, pop(&head_temp_stack));
    }

    // Output main stack
    puts("Main stack:");
    while (head_main_stack) {
        printf("%d\n", pop(&head_main_stack));
    }
}
