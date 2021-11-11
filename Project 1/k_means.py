#Ruide Xie

from image_utils import *
import math


def initial_guess(k):
    means_list = []
    for i in range(int(k)):
        color = random_color()
        means_list.append(color)
    return means_list

def color_distance(color1, color2):
    distance = math.sqrt((color1[0]-color2[0])**2+((color1[1]-color2[1])**2)+(color1[2]-color2[2])**2)
    return distance

def update_assignment(image, means_list):
    #temp=[0]*len(image[0])
    assignments=[[0]*len(image[0]) for i in range(len(image))]
    for x in range(len(image)):
        for y in range(len(image[0])):
            min = color_distance(image[x][y], means_list[0])
            assignments[x][y] = 0
            for z in range(len(means_list)):
                color1 = image[x][y]
                color2 = means_list[z]
                distance = color_distance(color1, color2)
                if distance < min:
                    min = distance
                    assignments[x][y] = z
    return assignments

def update_means(image, assignments, k):
    means = initial_guess(k)
    #assignments = update_assignment(image, means)
    for i in range(int(k)):
        for j in range(len(assignments)):
            assigned_color = []
            red = green = blue = 0
            for l in range(len(assignments[0])):
                if assignments[j][l] == i:
                    assigned_color.append(image[j][l])
                    red += image[j][l][0]
                    green += image[j][l][1]
                    blue += image[j][l][2]
            if len(assigned_color) == 0:
                means[i] = (0,0,0)
            else:
                means[i] = (red//len(assigned_color), green//len(assigned_color), blue//len(assigned_color))
    return means

def k_means(image, k):
    means = initial_guess(k)
    assignment1 = update_assignment(image, means)
    means = update_means(image, assignment1, k)
    assignment2 = update_assignment(image, means)
    while assignment1 != assignment2:
        assignment1 = assignment2
        means = update_means(image, assignment2, k)
        assignment2 = update_assignment(image, means)
    return means, assignment2