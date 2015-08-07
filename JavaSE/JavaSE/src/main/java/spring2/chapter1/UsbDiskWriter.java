package spring2.chapter1;

public class UsbDiskWriter implements IDeviceWriter {

	@Override
	public void saveToDevice() {
		System.out.println("写入至U盘");
	}

}
