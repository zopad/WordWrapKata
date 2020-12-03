package cas.kata;

public class Wrapper {

	public static String wrap(String text, int maxWidth) {
		String[] words = cleanInput(text).split(" ");
		int characterCount = 0;
		StringBuilder output = new StringBuilder();

		for (String word : words) {
			if (characterCount + word.length() < maxWidth) {
				output.append(word);
				characterCount += word.length();
			} else {
				putWordInNewLine(output, word);
				characterCount = word.length();
			}
			if (getLastChar(output) == '\n') {
				characterCount = 0;
			} else {
				output.append(" ");
				characterCount++;
			}
		}
		return output.toString().trim();
	}

	private static void putWordInNewLine(StringBuilder output, String word) {
		int trailingSpacePosition = output.length() - 1;
		output.deleteCharAt(trailingSpacePosition);
		output.append("\n").append(word);
	}

	private static char getLastChar(StringBuilder output) {
		return output.charAt(output.length() - 1);
	}

	private static String cleanInput(String input) {
		String treatNewLineAsWord = "\n ";
		return input.replace("\n", treatNewLineAsWord).trim();
	}
}
