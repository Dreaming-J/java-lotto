package lotto.module;

import lotto.view.OutputView;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RepeatModule {

    protected <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }

    protected <T> void repeat(Consumer<T> inputReader, T parameter) {
        try {
            inputReader.accept(parameter);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            repeat(inputReader, parameter);
        }
    }

    protected <T, R> R repeat(Function<T, R> inputReader, T parameter) {
        try {
            return inputReader.apply(parameter);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return repeat(inputReader, parameter);
        }
    }
}
