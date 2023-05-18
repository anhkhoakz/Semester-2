import numpy as np


def create_matrix_A():
    # A matrix information
    A_n_rows, A_n_cols = 10, 10
    A_low, A_high = 1, 101
    # Creating A matrix
    A = np.random.randint(A_low, A_high, size=(A_n_rows, A_n_cols))
    return A


def create_matrix_B():
    # B matrix information
    B_n_rows, B_n_cols = 2, 10
    B_low, B_high = 1, 21
    # Creating B matrix
    B = np.random.randint(B_low, B_high, size=(B_n_rows, B_n_cols))
    return B


def create_matrix_C():
    # C matrix information
    C_n_rows, C_n_cols = 10, 2
    C_low, C_high = 1, 21
    # Creating C matrix
    C = np.random.randint(C_low, C_high, size=(C_n_rows, C_n_cols))
    return C


def cau_A(A, B, C):
    A1 = np.add(A, A.T)
    A2 = np.add(np.matmul(C, B), np.matmul(B.T, C.T))
    A_result = np.add(A1, A2)
    print("\nKet qua cau A:")
    print(A_result)


def cau_B(A):
    A_res = np.zeros((A.shape[0], A.shape[1]))
    for i in range(10, 20):
        A_res += np.linalg.matrix_power((A/float(i)), i - 9)
    print("\nKet qua cau B:")
    print(A_res)


def cau_C(A):
    A_odd = A[1::2]
    print("\nKet qua cau C:")
    print("Odd vector:")
    print(A_odd)


def cau_D(A):
    odd = []
    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
            if A[i][j] % 2 != 0:
                odd.append(A[i][j])
    print("\nKet qua cau D:")
    print(odd)


def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(np.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


def cau_E(A):
    prime_matrix = []

    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
            if isPrime(A[i, j]):
                prime_matrix.append(A[i, j])

    prime_vector = np.array(prime_matrix)
    print("\nKet qua cau E:")
    print("Prime vector:")
    print(prime_vector)


def cau_F(C, B):
    D = np.matmul(C, B)
    D_res = []

    for i in range(D.shape[0]):
        if i % 2 != 0:
            D_res += [np.flipud(D[i, :])]
        else:
            D_res += [D[i, :]]
    print("\nKet qua cau F:")
    print(np.reshape(D_res, (D.shape[0], D.shape[1])))


def countPrime(row):
    count = 0
    for num in row:
        if isPrime(num):
            count += 1
    return count


def cau_G(A):
    primeCounts = []

    for row in A:
        count = countPrime(row)
        primeCounts.append(count)

    max_count = max(primeCounts)
    max_indices = []
    for i in range(len(primeCounts)):
        count = primeCounts[i]
        if count == max_count:
            max_indices.append(i)
    print("\nKet qua cau G:")
    print("Rows have maximum count of prime numbers:")

    for i in max_indices:
        print(A[i])


def cau_H(A):
    max_len = 0
    max_rows = []
    for i in range(A.shape[0]):
        cur_len = 0
        cur_seq = []
        for j in range(A.shape[1]):
            if A[i][j] % 2 == 1:
                cur_seq.append(A[i][j])
                cur_len += 1
            else:
                cur_seq = []
                cur_len = 0
            if cur_len > max_len:
                max_len = cur_len
                max_rows = [i]
            elif cur_len == max_len:
                max_rows.append(i)
    print("\nKet qua cau H:")
    for i in max_rows:
        print(A[i])


def main():
    A_matrix = create_matrix_A()
    print("Ma tran A:\n", A_matrix)
    B_matrix = create_matrix_B()
    print("Ma tran B:\n", B_matrix)
    C_matrix = create_matrix_C()
    print("Ma tran C:\n", C_matrix)
    cau_A(A_matrix, B_matrix, C_matrix)
    cau_B(A_matrix)
    cau_C(A_matrix)
    cau_D(A_matrix)
    cau_E(A_matrix)
    cau_F(C_matrix, B_matrix)
    cau_G(A_matrix)
    cau_H(A_matrix)


if __name__ == '__main__':
    main()
