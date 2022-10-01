package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.TendorException;
import com.Exception.VenderException;
import com.bean.Tender;
import com.bean.TenderBid;
import com.bean.TenderStatus;
import com.bean.Vender;
import com.utility.DButil;

public class TenderDaoImp implements TenderDao {

	@Override
	public String registerVender(Vender vender) {

		String message = "Vender Not Added";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into vender(vname, vemail,vpassword) values(?,?,?)");

			ps.setString(1, vender.getVenderName());
			ps.setString(2, vender.getVenderEmail());
			ps.setString(3, vender.getvPassword());

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Vender Register Sucessfull";
			}

		} catch (Exception e) {
			message = e.getMessage();
		}

		return message;

	}

	@Override
	public ArrayList<Vender> showVender() throws VenderException {
		ArrayList<Vender> list = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from vender");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("vid");
				String name = rs.getString("vname");
				String email = rs.getString("vemail");
				String passWord = rs.getString("vpassword");

				list.add(new Vender(id, name, email, passWord));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			throw new VenderException(e.getMessage());

		}
		if (list.size() == 0) {
			throw new VenderException("No Vender Found Register A vender First!!!!");
		}

		return list;
	}

	@Override
	public String addTender(Tender tender) {
		String message = "Tender Not Added";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into tender(tname, tamount) values(?,?)");

			ps.setString(1, tender.getCategory());
			ps.setInt(2, tender.getAmmount());

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Tender Register Sucessfull";
			}

		} catch (Exception e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public ArrayList<Tender> showTender() throws TendorException {

		ArrayList<Tender> tlist = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Select * from tender");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("tid");
				String name = rs.getString("tname");
				int amount = rs.getInt("tamount");

				tlist.add(new Tender(id, name, amount));

			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new TendorException(e.getMessage());
		}

		if (tlist.size() == 0) {
			throw new TendorException("No Tendor Found This Time Please Add to See the Tender");
		}

		return tlist;
	}

	@Override
	public Vender loginVender(String userName, String password) throws VenderException {

		Vender vender = null;

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from vender where vemail=? AND vpassword=?");

			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("vid");
				String name = rs.getString("vname");
				String email = rs.getString("vemail");
				String pass = rs.getString("vpassword");

				vender = new Vender(id, name, email, pass);

			} else
				throw new VenderException("Invalid Username or password.. ");

		} catch (Exception e) {

			throw new VenderException(e.getMessage());

		}

		return vender;
	}

	@Override
	public String addBidForTender(int venderId, int tenderId, int amount) throws TendorException {
		String msg = "No Related To The Temnder";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into tenderbid(bid, btid, amount ) values (?,?,?)");

			ps.setInt(1, venderId);
			ps.setInt(2, tenderId);
			ps.setInt(3, amount);

			int x = ps.executeUpdate();

			if (x > 0) {
				msg = "Tender Register Sucessfull";
			} else
				throw new TendorException("Please Check once Enter Information");

		} catch (Exception e) {

			msg = e.getMessage();

		}

		return msg;
	}

	@Override
	public List<TenderStatus> statusOftenderBid(int venderId, int tenderid) throws TendorException {

		ArrayList<TenderStatus> tstatus = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					" select v.vid,v.vname,t.tid,t.tname,b.amount,b.status from  vender v inner join tender t inner join tenderbid b on v.vid=b.bid AND t.tid=b.btid AND b.bid=? AND b.btid=?");

			ps.setInt(1, venderId);
			ps.setInt(2, tenderid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				int vid = rs.getInt("vid");
				String name = rs.getString("vname");
				int tid = rs.getInt("tid");
				String tendername = rs.getString("tname");
				int amount = rs.getInt("amount");
				int status = rs.getInt("status");

				if (status == 0) {

					tstatus.add(new TenderStatus(vid, name, tid, tendername, amount, "NOT SELECTED"));

				} else {

					tstatus.add(new TenderStatus(vid, name, tid, tendername, amount, "SELECTED"));

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (tstatus.size() == 0) {
			throw new TendorException("You Enter Wrong Info");
		}

		return tstatus;

	}

	@Override
	public List<TenderStatus> HistoryOfTender(int venderId) throws VenderException {

		ArrayList<TenderStatus> thistory = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"select v.vid,v.vname,t.tid,t.tname,b.amount,b.status from  vender v inner join tender t inner join tenderbid b on v.vid=b.bid AND t.tid=b.btid AND v.vid=?");

			ps.setInt(1, venderId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int vid = rs.getInt("vid");
				String name = rs.getString("vname");
				int tid = rs.getInt("tid");
				String tendername = rs.getString("tname");
				int amount = rs.getInt("amount");
				int status = rs.getInt("status");

				if (status == 0) {

					thistory.add(new TenderStatus(vid, name, tid, tendername, amount, "NOT SELECTED"));

				} else {

					thistory.add(new TenderStatus(vid, name, tid, tendername, amount, "SELECTED"));

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (thistory.size() == 0) {
			throw new VenderException("You Enter Wrong Info");
		}

		return thistory;

	}

	@Override
	public List<TenderBid> showTenderBid() {
		ArrayList<TenderBid> arr = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from tenderbid");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int bid = rs.getInt("bid");
				int btid = rs.getInt("btid");
				int amount = rs.getInt("amount");
				int status = rs.getInt("status");
				if (status == 0) {

					arr.add(new TenderBid(bid, btid, amount, "NOT Assigned"));

				}

				else {
					arr.add(new TenderBid(bid, btid, amount, "Assigned"));
				}

			}

		

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return arr;
	}

	@Override
	public List<TenderBid> showMinTenderBid() throws TendorException {
		
		ArrayList<TenderBid> arr = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement
					(" select bid, btid, min(amount) amount, status from tenderbid group by btid");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int bid = rs.getInt("bid");
				int btid = rs.getInt("btid");
				int amount = rs.getInt("amount");
				int status = rs.getInt("status");
				if (status == 0) {

					arr.add(new TenderBid(bid, btid, amount, "NOT Assigned"));

				}

				else {
					arr.add(new TenderBid(bid, btid, amount, "Assigned"));
				}

			}

			if (arr.size() == 0) {
				throw new TendorException("No Tender Bid Found");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return arr;
		
		
		
		
	}

	@Override
	public List<TenderBid> showMinStatusTenderBid(int ans) throws TendorException {
		
		ArrayList<TenderBid> arr = new ArrayList<>();
		
		
		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement
					("select * from tenderbid where status=?");
			
			ps.setInt(1, ans);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int bid = rs.getInt("bid");
				int btid = rs.getInt("btid");
				int amount = rs.getInt("amount");
				int status = rs.getInt("status");
				if (status == 0) {

					arr.add(new TenderBid(bid, btid, amount, "NOT Assigned"));

				}

				else {
					arr.add(new TenderBid(bid, btid, amount, "Assigned"));
				}

			}

			if (arr.size() == 0) {
				throw new TendorException("No Tender Bid Found");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		return arr;
		
		
		
		
		
		
		
		
	}

	@Override
	public String assignTender(int bid, int btid) throws TendorException {
		String message = "Vender Not Added";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement
					("update tenderbid set status=1 where Status=0 AND bid=? AND btid=? ");

			ps.setInt(1, bid);
			ps.setInt(2, btid);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Tender Assign";
			}else throw new TendorException("Tender is Already assign Please Recheck it");

		} catch (Exception e) {
			message = e.getMessage();
		}

		return message;
	}

}
