package com.donny.militarychessapp.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.donny.militarychessapp.R;

import java.util.ArrayList;

/**
 * Created by youansheng on 2016/12/24.
 */
public class DeviceshowAdapter extends BaseAdapter {
    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    private ArrayList<Device> devices;
    private Context context;
    private TextView devicename;
    private TextView deviceaddress;

    //显示设备是否已经配对
    private ImageView device_ifchoiseimg;
    private TextView device_ifchoise;


    public DeviceshowAdapter(Context context, ArrayList<Device> devices) {
        this.context = context;
        this.devices = devices;
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public Object getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.device_cell_layout,null);
        Device device = devices.get(position);
        devicename = (TextView) v.findViewById(R.id.device_name);
        deviceaddress = (TextView) v.findViewById(R.id.device_address);
        devicename.setText(device.getDeviceName());
        deviceaddress.setText(device.getDeviceAddress());

        device_ifchoiseimg = (ImageView) v.findViewById(R.id.device_ifchoiseimg);
        device_ifchoise = (TextView) v.findViewById(R.id.device_ifchoise);
        if (device.getBundlestate() == BluetoothDevice.BOND_BONDED) {
            device_ifchoiseimg.setImageResource(R.drawable.ic_check_24dp);
            device_ifchoise.setText("已配对");
        }
        return v;
    }
}
