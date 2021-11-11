#Ruide Xie

from k_means import *
from image_utils import *

if __name__ == "__main__":
    input_file = input("Please enter the input filename: ")
    image = read_ppm(input_file)
    k = input("Please enter the amount of color: ")
    output_file = input("Please enter the output file name: ")
    means, assignments = k_means(image, k)
    for e in range(len(assignments)):
        for f in range(len(assignments[0])):
            image[e][f] = means[assignments[e][f]]

    save_ppm(output_file+".ppm", image)
    print("Saved")