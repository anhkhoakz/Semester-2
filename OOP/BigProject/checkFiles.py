import difflib
import os


def compare_files(folder1, folder2):
    file_list1 = os.listdir(folder1)
    file_list2 = os.listdir(folder2)

    common_files = set(file_list1).intersection(file_list2)

    for filename in common_files:
        file_path1 = os.path.join(folder1, filename)
        file_path2 = os.path.join(folder2, filename)

        with open(file_path1, "r") as file1, open(file_path2, "r") as file2:
            lines1 = file1.readlines()
            lines2 = file2.readlines()

            # Switched lines2 and lines1
            diff = difflib.unified_diff(lines2, lines1)

            # Check if there are any differences
            if any(diff):
                print(f"Differences in file: {filename}")
                print("=========================================")

                for line in diff:
                    print(line)

                print("\n")


# Provide the paths to the folders to compare
folder1 = "./expected_output"
folder2 = "./output"

compare_files(folder1, folder2)

# Source: anhkhoakz
