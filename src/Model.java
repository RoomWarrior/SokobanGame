public class Model {

    private final Viewer viewer;
    private final LevelsFromLocal levelsFromLocal;
    private final LevelsFromServer levelsFromServer;
    private int[][] desktop;
    private int[][] goalPos;
    private int indexX;
    private int indexY;
    private int level;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        levelsFromLocal = new LevelsFromLocal();
        levelsFromServer = new LevelsFromServer();
        level = 1;
        init();
    }

    private void init() {
        desktop = getLevelOne();
        initPlayerPos(desktop);
        initGoalPos(desktop);
    }

    private void nextLevel() {

        if (level == 9) {
            level = 1;
        } else {
            level++;
        }
        switch (level) {
            case 2:
                desktop = getLevelTwo();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 3:
                desktop = getLevelThree();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 4:
                desktop = getLevelFour();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 5:
                desktop = getLevelFive();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 6:
                desktop = getLevelSix();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 7:
                desktop = getLevelSeven();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 8:
                desktop = getLevelEight();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            case 9:
                desktop = getLevelNine();
                initPlayerPos(desktop);
                initGoalPos(desktop);
                break;
            default:
                level = 1;
                init();
                break;
        }
    }

    private int[][] getLevelOne() {
        return new int[][]{
                {0, 0, 2, 2, 2, 0, 0, 0},
                {0, 0, 2, 4, 2, 0, 0, 0},
                {0, 0, 2, 0, 2, 2, 2, 2},
                {2, 2, 2, 3, 0, 3, 4, 2},
                {2, 4, 0, 3, 1, 2, 2, 2},
                {2, 2, 2, 2, 3, 2, 0, 0},
                {0, 0, 0, 2, 4, 2, 0, 0},
                {0, 0, 0, 2, 2, 2, 0, 0}
        };
    }

    private int[][] getLevelTwo() {
        return new int[][]{
                {2, 2, 2, 2, 2, 0, 0, 0, 0},
                {2, 0, 0, 0, 2, 0, 0, 0, 0},
                {2, 0, 3, 1, 2, 0, 2, 2, 2},
                {2, 0, 3, 3, 2, 0, 2, 4, 2},
                {2, 2, 2, 0, 2, 2, 2, 4, 2},
                {0, 2, 2, 0, 0, 0, 0, 4, 2},
                {0, 2, 0, 0, 0, 2, 0, 0, 2},
                {0, 2, 0, 0, 0, 2, 2, 2, 2},
                {0, 2, 2, 2, 2, 2, 0, 0, 0}
        };
    }


    private int[][] getLevelThree() {
        return new int[][]{
                {0, 2, 2, 2, 2, 0},
                {2, 2, 0, 0, 2, 0},
                {2, 0, 1, 3, 2, 0},
                {2, 2, 3, 0, 2, 2},
                {2, 2, 0, 3, 0, 2},
                {2, 4, 3, 0, 0, 2},
                {2, 4, 4, 0, 4, 2},
                {2, 2, 2, 2, 2, 2}
        };
    }

    private int[][] getLevelFour() {
        int[][] levelFour = new int[0][];
        try {
            levelFour = levelsFromLocal.nextLevel("res/levels/level4.sok");
        } catch (Exception e) {
            init();
        }
        return levelFour;
    }

    private int[][] getLevelFive() {
        int[][] levelFive = new int[0][];
        try {
            levelFive = levelsFromLocal.nextLevel("res/levels/level5.sok");
        } catch (Exception e) {
            init();
        }
        return levelFive;
    }

    private int[][] getLevelSix() {
        int[][] levelSix = new int[0][];
        try {
            levelSix = levelsFromLocal.nextLevel("res/levels/level6.sok");
        } catch (Exception e) {
            init();
        }
        return levelSix;
    }

    private int[][] getLevelSeven() {
        int[][] levelSeven;
        levelSeven = levelsFromServer.getLevelFromServer("7");
        return levelSeven;
    }

    private int[][] getLevelEight() {
        int[][] levelEight;
        levelEight = levelsFromServer.getLevelFromServer("8");
        return levelEight;
    }

    private int[][] getLevelNine() {
        int[][] levelNine;
        levelNine = levelsFromServer.getLevelFromServer("9");
        return levelNine;
    }

    public void setLevel(int lvl) {
        switch (lvl) {
            case 1:
                desktop = getLevelOne();
                level = 1;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 2:
                desktop = getLevelTwo();
                level = 2;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 3:
                desktop = getLevelThree();
                level = 3;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 4:
                desktop = getLevelFour();
                level = 4;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 5:
                desktop = getLevelFive();
                level = 5;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 6:
                desktop = getLevelSix();
                level = 6;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 7:
                desktop = getLevelSeven();
                level = 7;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 8:
                desktop = getLevelEight();
                level = 8;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
            case 9:
                desktop = getLevelNine();
                level = 9;
                initPlayerPos(desktop);
                initGoalPos(desktop);
                viewer.update();
                break;
        }
    }

    public void restart() {
        if (level == 1) {
            desktop = getLevelOne();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 2) {
            desktop = getLevelTwo();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 3) {
            desktop = getLevelThree();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 4) {
            desktop = getLevelFour();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 5) {
            desktop = getLevelFive();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 6) {
            desktop = getLevelSix();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 7) {
            desktop = getLevelSeven();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 8) {
            desktop = getLevelEight();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        } else if (level == 9) {
            desktop = getLevelNine();
            initPlayerPos(desktop);
            initGoalPos(desktop);
            viewer.update();
        }
    }

    public void exit() {
        System.exit(0);
    }


    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        checkGoal();
        viewer.update();
        won();
    }

    private void checkGoal() {
        int x, y;
        for (int[] i : goalPos) {
            x = i[0];
            y = i[1];
            if (desktop[x][y] == 0) {
                desktop[x][y] = 4;
                break;
            }
        }
    }

    private void won() {
        boolean isWon = true;
        int x, y;
        for (int[] i : goalPos) {
            x = i[0];
            y = i[1];
            if (desktop[x][y] != 3) {
                isWon = false;
                break;
            }
        }
        if (isWon) {
            if (viewer.showDialogWon()) {
                nextLevel();
                viewer.update();
            }
        }
    }

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void initGoalPos(int[][] desktop) {
        int size = 0;
        for (int[] ints : desktop) {
            for (int anInt : ints) {
                if (anInt == 4) {
                    size++;
                }
            }
        }
        goalPos = new int[size][];
        int[] temp;
        int index = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    goalPos[index] = temp;
                    index++;
                }
            }
        }
    }

    private void initPlayerPos(int[][] desktop) {
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    indexX = i;
                    indexY = j;
                    this.desktop[indexX][indexY] = 1;
                    return;
                }
            }
        }
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
