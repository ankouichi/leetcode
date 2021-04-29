package org.problems.backtracking.robotroomcleaner;

/**
 * @author: Daniel
 * @date: 2021/4/15 16:42
 * @description:
 *
 * Given a robot cleaner in a room modeled as a grid.
 * Each cell in the grid can be empty or blocked.
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * Example:
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 *
 * Notes:
 *
 *     The input is only given to initialize the room and the robot's position internally.
 *     You must solve this problem "blindfolded". In other words, you must control the robot
 *     using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 *
 *     The robot's initial position will always be in an accessible cell.
 *     The initial direction of the robot will be facing up.
 *     All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 *     Assume all four edges of the grid are all surrounded by wall.
 *
 */
public class LC489_Hard_RobotRoomCleaner {
    public void cleanRoom(Robot robot) {

    }
}
