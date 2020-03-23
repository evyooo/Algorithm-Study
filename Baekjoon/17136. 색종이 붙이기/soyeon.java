//https://ye-eun-lee.postype.com/post/3626323 참고
import java.util.*;
public class Main {
	static int mat[][]=new int[10][10];
	static boolean isVisit[][]=new boolean[10][10];
	static int Answer = 987654321;
	static int Total_Cnt;
	static boolean Already_Answer = true;
	static LinkedList<position> set1=new LinkedList<position>();
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int cube[]= {0, 5,5,5,5,5};

		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				mat[i][j]=in.nextInt();
				if(mat[i][j]==1) {
					set1.add(new position(i,j));
					Total_Cnt++;
	                Already_Answer = false;
				}
			}
		}
		solution();
	}
	static boolean Can_Fill(int x, int y, int r)
	{
		int Cnt = 0;
		for (int i = x; i < x + r; i++)
		{
			if (i >= 10) break;
			for (int j = y; j < y + r; j++)
			{
				if (j >= 10) break;
				if (mat[i][j] == 1 && isVisit[i][j] == false)
				{
					Cnt++;
				}
			}
		}

		if (Cnt == r * r) return true;
		else return false;
	}

	static int Find_Range(int x, int y)
	{//색종이로 덮을 수 있는 최대 크기 
		if (Can_Fill(x, y, 2) == true)
		{
			if (Can_Fill(x, y, 3) == true)
			{
				if (Can_Fill(x, y, 4) == true)
				{
					if (Can_Fill(x, y, 5) == true)
					{
						return 5;
					}
					return 4;
				}
				return 3;
			}
			return 2;
		}
		return 1;
	}

	static void Make_Visit(int x, int y, int r, boolean t)
	{//방문한 위치인지 확인
		for (int i = x; i < x + r; i++)
		{
			for (int j = y; j < y + r; j++)
			{
				isVisit[i][j] = t;
			}
		}
	}

	static void DFS(int Idx, int One, int Two, int Three, int Four, int Five, int Total)
	{
		int Use = One + Two + Three + Four + Five;

		if (Answer < Use) //너무 많이 사용했으면
			return;
		
		if (Total == Total_Cnt)
		{
			Answer = Math.min(Answer, Use);
			return;
		}
		
		if (isVisit[set1.get(Idx).row][set1.get(Idx).col] == true)
		{//이미 방문했으면 다음 위치를 본다
			DFS(Idx + 1, One, Two, Three, Four, Five, Total);
			return;
		}

		
		int Can_Fill = Find_Range(set1.get(Idx).row, set1.get(Idx).col);
		
		if (Can_Fill == 1)
		{
			if (One + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, true);
				DFS(Idx + 1, One + 1, Two, Three, Four, Five, Total + 1);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, false);
			}
		}
		else if (Can_Fill == 2)
		{
			if (Two + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, true);
				DFS(Idx + 1, One, Two + 1, Three, Four, Five, Total + 4);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, false);
			}
			if (One + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, true);
				DFS(Idx + 1, One + 1, Two, Three, Four, Five, Total + 1);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, false);
			}
		}
		else if (Can_Fill == 3)
		{
			if (Three + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 3, true);
				DFS(Idx + 1, One, Two, Three + 1, Four, Five, Total + 9);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 3, false);
			}

			if (Two + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, true);
				DFS(Idx + 1, One, Two + 1, Three, Four, Five, Total + 4);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, false);
			}

			if (One + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, true);
				DFS(Idx + 1, One + 1, Two, Three, Four, Five, Total + 1);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, false);
			}    
		}
		else if (Can_Fill == 4)
		{
			if (Four + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 4, true);
				DFS(Idx + 1, One, Two, Three, Four + 1, Five, Total + 16);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 4, false);
			}

			if (Three + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 3, true);
				DFS(Idx + 1, One, Two, Three + 1, Four, Five, Total + 9);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 3, false);
			}

			if (Two + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, true);
				DFS(Idx + 1, One, Two + 1, Three, Four, Five, Total + 4);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, false);
			}

			if (One + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, true);
				DFS(Idx + 1, One + 1, Two, Three, Four, Five, Total + 1);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, false);
			}
		}
		else if (Can_Fill == 5)
		{
			if (Five + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 5, true);
				DFS(Idx + 1, One, Two, Three, Four, Five + 1, Total + 25);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 5, false);
			}

			if (Four + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 4, true);
				DFS(Idx + 1, One, Two, Three, Four + 1, Five, Total + 16);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 4, false);
			}

			if (Three + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 3, true);
				DFS(Idx + 1, One, Two, Three + 1, Four, Five, Total + 9);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 3, false);
			}

			if (Two + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, true);
				DFS(Idx + 1, One, Two + 1, Three, Four, Five, Total + 4);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 2, false);
			}

			if (One + 1 <= 5)
			{
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, true);
				DFS(Idx + 1, One + 1, Two, Three, Four, Five, Total + 1);
				Make_Visit(set1.get(Idx).row, set1.get(Idx).col, 1, false);
			}        
		}
	}

	static void solution()
	{
		if (Already_Answer == true)
		{//갯수 확인해서 1이 없으면 바로 리턴
			System.out.println("0");
			return;
		}

		DFS(0, 0, 0, 0, 0, 0, 0);
		
		if (Answer == 987654321) Answer = -1;
		System.out.println(Answer);
	}
}
class position{
	int row, col;
	public position(int row, int col) {
		this.row=row;
		this.col=col;
	}
}
