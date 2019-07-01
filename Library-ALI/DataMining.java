package com.bayudwiyansatria.mining;

import com.bayudwiyansatria.mat.Mat;

public class DataMining extends Mat {
    /*
    private double[][] Normalization_MinMax(double[][] data, int newmin, int newmax) {
        double[][] var10000 = new double[data.length][data[0].length];
        double[][] _min = this.getMin(data);
        double[][] _max = this.getMax(data);
        double[] calculate = this.Calculate(_max[0], _min[0], "-");
        double[][] _minus = this.Calculate(data, _min[0], "-");
        double[][] _cross = this.Calculate(_minus, (double)(newmax - newmin), "*");
        double[][] _division = this.Calculate(_cross, calculate, "/");
        double[][] _output = this.Calculate(_division, (double)newmin, "+");
        return _output;
    }

    private double[][] Normalization_ZScore(double[][] data) {
        double[][] var10000 = new double[data.length][data[0].length];
        double[] _mean = this.getAverage(data, "col");
        double[] _std = this.getStd(data, "col");
        double[][] calculate = this.Calculate(data, _mean, "-");
        double[][] _output = this.Calculate(calculate, _std, "/");
        return _output;
    }

    private double[][] Normalization_DecimalScaling(double[][] data, int[] divider) {
        if (data[0].length != divider.length) {
            this.warning("Size of data dimension does not match with divider size!");
        }

        double[][] _output = this.Calculate(data, this.int_to_double(divider), "/");
        return _output;
    }

    private double[][] Normalization_Sigmoidal(double[][] data) {
        double[][] _output = new double[data.length][data[0].length];
        this.Normalization_ZScore(data);
        double exp = 2.718281828;

        for(int i = 0; i < data.length; ++i) {
            for(int j = 0; j < data[0].length; ++j) {
                _output[i][j] = (1.0D - Mat.pow(exp, -data[i][j])) / (1.0D + Mat.pow(exp, -data[i][j]));
            }
        }

        return _output;
    }

    private double[][] Normalization_Softmax(double[][] data, int linear_response) {
        double[][] _output = new double[data.length][data[0].length];
        double[] _mean = this.getAverage(data, "col");
        double[] _std = this.getStd(data, "col");
        double[][] calculate = this.Calculate(data, _mean, "-");
        double[] divider = this.Calculate(_std, (double)linear_response / 6.283185307179586D, "*");
        double[][] tranfdata = this.Calculate(calculate, divider, "/");
        double exp = 2.718281828;

        for(int i = 0; i < data.length; ++i) {
            for(int j = 0; j < data[0].length; ++j) {
                _output[i][j] = 1.0D / (1.0D + Mat.pow(exp, -tranfdata[i][j]));
            }
        }

        return _output;
    }

    public double[][] Normalization(String algorithm, double[][] data, int linear_response) {
        double[][] _output = new double[data.length][data[0].length];
        algorithm = algorithm.toLowerCase();
        byte var8 = -1;
        switch(algorithm.hashCode()) {
            case 0:
                if (algorithm.equals("softmax")) {
                    var8 = 4;
                }
                break;
            case 1:
                if (algorithm.equals("minmax")) {
                    var8 = 0;
                }
                break;
            case 2:
                if (algorithm.equals("decimalscaling")) {
                    var8 = 2;
                }
                break;
            case 3:
                if (algorithm.equals("zscore")) {
                    var8 = 1;
                }
                break;
            case 1057539897:
                if (algorithm.equals("sigmoidal")) {
                    var8 = 3;
                }
        }

        switch(var8) {
            case 0:
                this.warning("Set new minimum and maximum value!");
                break;
            case 1:
                this.warning("You just _set data as a parameter for Z-Score!");
                break;
            case 2:
                this.warning("Set array of divider!");
                break;
            case 3:
                this.warning("You just _set data as a parameter for Sigmoidal!");
                break;
            case 4:
                _output = this.Normalization_Softmax(data, linear_response);
                break;
            default:
                this.warning("Unknown algorithm!");
        }

        return _output;
    }

    public double[][] Normalization(String algorithm, double[][] data, int newmin, int newmax) {
        double[][] _output = new double[data.length][data[0].length];
        algorithm = algorithm.toLowerCase();
        byte var9 = -1;
        switch(algorithm.hashCode()) {
            case 0:
                if (algorithm.equals("softmax")) {
                    var9 = 4;
                }
                break;
            case 1:
                if (algorithm.equals("minmax")) {
                    var9 = 0;
                }
                break;
            case 2:
                if (algorithm.equals("decimalscaling")) {
                    var9 = 2;
                }
                break;
            case 3:
                if (algorithm.equals("zscore")) {
                    var9 = 1;
                }
                break;
            case 1057539897:
                if (algorithm.equals("sigmoidal")) {
                    var9 = 3;
                }
        }

        switch(var9) {
            case 0:
                _output = this.Normalization_MinMax(data, newmin, newmax);
                break;
            case 1:
                this.warning("You just _set data as a parameter for Z-Score!");
                break;
            case 2:
                this.warning("Set array of divider!");
                break;
            case 3:
                this.warning("You just _set data as a parameter for Sigmoidal!");
                break;
            case 4:
                this.warning("Set linear response value!");
                break;
            default:
                this.warning("Unknown algorithm!");
        }

        return _output;
    }

    public double[][] Normalization(String algorithm, double[][] data) {
        double[][] _output = new double[data.length][data[0].length];
        algorithm = algorithm.toLowerCase();
        byte var7 = -1;
        switch(algorithm.hashCode()) {
            case 0:
                if (algorithm.equals("softmax")) {
                    var7 = 4;
                }
                break;
            case 1:
                if (algorithm.equals("minmax")) {
                    var7 = 0;
                }
                break;
            case 2:
                if (algorithm.equals("decimalscaling")) {
                    var7 = 2;
                }
                break;
            case 3:
                if (algorithm.equals("zscore")) {
                    var7 = 1;
                }
                break;
            case 4:
                if (algorithm.equals("sigmoidal")) {
                    var7 = 3;
                }
        }

        switch(var7) {
            case 0:
                this.warning("Set new minimum and maximum value!");
                break;
            case 1:
                _output = this.Normalization_ZScore(data);
                break;
            case 2:
                this.warning("Set array of divider!");
                break;
            case 3:
                _output = this.Normalization_Sigmoidal(data);
                break;
            case 4:
                this.warning("Set linear response value!");
                break;
            default:
                this.warning("Unknown algorithm!");
        }

        return _output;
    }

    public double[][] Normalization(String algorithm, double[][] data, int[] divider) {
        double[][] _output = new double[data.length][data[0].length];
        algorithm = algorithm.toLowerCase();
        byte var8 = -1;
        switch(algorithm.hashCode()) {
            case 0:
                if (algorithm.equals("softmax")) {
                    var8 = 4;
                }
                break;
            case 1:
                if (algorithm.equals("minmax")) {
                    var8 = 0;
                }
                break;
            case 2:
                if (algorithm.equals("decimalscaling")) {
                    var8 = 2;
                }
                break;
            case 3:
                if (algorithm.equals("zscore")) {
                    var8 = 1;
                }
                break;
            case 4:
                if (algorithm.equals("sigmoidal")) {
                    var8 = 3;
                }
        }

        switch(var8) {
            case 0:
                this.warning("Set new minimum and maximum value!");
                break;
            case 1:
                this.warning("You just _set data as a parameter for Z-Score!");
                break;
            case 2:
                _output = this.Normalization_DecimalScaling(data, divider);
                break;
            case 3:
                this.warning("You just _set data as a parameter for Sigmoidal!");
                break;
            case 4:
                this.warning("Set linear response value!");
                break;
            default:
                this.warning("Unknown algorithm!");
        }

        return _output;
    }

    public double[][] Normalization(String algorithm, int[][] data, int newmin, int newmax) {
        double[][] _output = this.Normalization(algorithm, this.int_to_double(data), newmin, newmax);
        return _output;
    }

    public double[][] Normalization(String algorithm, int[][] data) {
        double[][] _output = this.Normalization(algorithm, this.int_to_double(data));
        return _output;
    }

    public double[][] Normalization(String algorithm, int[][] data, int[] divider) {
        double[][] _output = this.Normalization(algorithm, this.int_to_double(data), divider);
        return _output;
    }

    public double[][] Normalization(String algorithm, int[][] data, int linear_response) {
        double[][] _output = this.Normalization(algorithm, this.int_to_double(data), linear_response);
        return _output;
    }

     */
}
