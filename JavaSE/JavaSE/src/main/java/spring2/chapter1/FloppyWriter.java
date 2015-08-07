package spring2.chapter1;

public class FloppyWriter implements IDeviceWriter {

	@Override
	public void saveToDevice() {
		System.out.println("写入至软盘");
	}

}
