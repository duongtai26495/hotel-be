package DuAn2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DuAn2.Dto.BookingDTO;
import DuAn2.Model.Checkin;
import DuAn2.Services.IttkhService;

@RestController
@RequestMapping(path = "/api/")
public class CheckinApi {
	 
	@Autowired
	IttkhService iService;
	
	@GetMapping("{CheckinNo}")
	public BookingDTO checkBooking (@PathVariable int CheckinNo) {
		Checkin checkin = iService.findBookingByCheckinID(CheckinNo);
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setBooking_id(CheckinNo);
		bookingDTO.setName(checkin.getHoTen());
		bookingDTO.setEmail(checkin.getEmail());
		bookingDTO.setPhoneNumber(checkin.getSoDT());
		bookingDTO.setRoomCode(checkin.getPhong().getMaPhong());
		bookingDTO.setRoomType(checkin.getPhong().getLoaiPhong().getTenLoaiPhong());
		bookingDTO.setCheckInDate(checkin.getNgayDat().toString());
		String ngayTra = checkin.getTraPhongs().toString();
		bookingDTO.setCheckOutDate(ngayTra);
		return bookingDTO;
	}
}
