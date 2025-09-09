#include <stdio.h>

int main() {
    int n, i, aprovados = 0, k;
    float soma = 0.0, maior, menor;

    // Solicita o número de alunos
    printf("Digite o número de alunos da turma: ");
    scanf("%d", &n);

    // Verifica se o número de alunos é válido
    if (n <= 0) {
        printf("Número inválido de alunos.\n");
        return 1;
    }

    float notas[n];

    // Leitura das notas
    for (i = 0; i < n; i++) {
        do {
            printf("Digite a nota do aluno %d (0.0 a 10.0): ", i + 1);
            scanf("%f", &notas[i]);
            if (notas[i] < 0.0 || notas[i] > 10.0)
                printf("Nota inválida. Tente novamente.\n");
        } while (notas[i] < 0.0 || notas[i] > 10.0);

        soma += notas[i];

        if (i == 0) {
            maior = menor = notas[i]; // Inicializa maior e menor
        } else {
            if (notas[i] > maior) maior = notas[i];
            if (notas[i] < menor) menor = notas[i];
        }

        if (notas[i] >= 6.0) {
            aprovados++;
        }
    }

    float media = soma / n;

    // Exibição dos resultados
    printf("\nMédia geral da turma: %.2f\n", media);
    printf("Maior nota: %.2f\n", maior);
    printf("Menor nota: %.2f\n", menor);
    printf("Quantidade de alunos aprovados: %d\n", aprovados);

    // Posição k informada pelo usuário
    printf("Digite a posição do aluno (0 a %d) para ver a nota: ", n - 1);
    scanf("%d", &k);

    if (k >= 0 && k < n) {
        printf("Nota do aluno na posição %d: %.2f\n", k, notas[k]);
    } else {
        printf("Posição inválida.\n");
    }

    return 0;
}
