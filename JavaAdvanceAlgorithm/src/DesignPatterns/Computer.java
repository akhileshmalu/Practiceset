package DesignPatterns;

/**
 * @author: Akhilesh Maloo
 * @date: 1/8/23.
 */
public class Computer {
    int ram;
    int memory;

    private Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.memory = builder.memory;
    }

    public int getRam() {
        return ram;
    }

    public int getMemory() {
        return memory;
    }

    public static class ComputerBuilder {
        int ram;
        int memory;

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }


        public ComputerBuilder setMemory(int memory) {
            this.memory = memory;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
